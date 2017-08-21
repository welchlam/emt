package com.welch.emt.dao;

import com.welch.emt.model.User;
import com.welch.emt.repository.UserRepository;
import com.welch.emt.util.Encryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017-6-4.
 */
@Component
public class UserDao {

    private static Logger Logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private UserRepository userRepository;

    @Value("${emt.app.admin}")
    private String adminUserName;

    public static boolean adminCreated = false;

    public void saveUser(User user){
        this.userRepository.save(user);
        /*User user = new User();
        user.setUserName("Welch");
        user.setPassword("Password");
        this.userRepository.save(user);*/
    }

    public void appUserInit(){
        if(!adminCreated){
            adminCreated = true;
            if(this.adminUserName!=null && !this.adminUserName.equals("")){
                List<User> list = this.userRepository.findByUserName(this.adminUserName);
                if (list.isEmpty()){
                    Logger.info("Creating application admin user.");
                    User user = new User();
                    user.setUserName(this.adminUserName);
                    user.setPassword(Encryptor.encrypt(this.adminUserName));
                    user.setRole("ADMIN");
                    this.userRepository.save(user);
                    Logger.info("Application admin user created successfully.");
                }
            }
        }
    }

    public boolean login(String userName, String password){
        List<User> list = this.userRepository.findByUserName(userName);
        if(list.isEmpty()){
            Logger.error("User not found: " + userName);
            return false;
        }
        User user = list.get(0);
        if(!password.equals(Encryptor.decrypt(user.getPassword()))){
            Logger.error("Invalid password: " + userName);
            return false;
        }
        return true;
    }
}
