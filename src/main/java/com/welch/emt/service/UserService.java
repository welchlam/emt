package com.welch.emt.service;

import com.welch.emt.dao.UserDao;
import com.welch.emt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-6-4.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void saveUser(User user){
        this.userDao.saveUser(user);
    }

    public void appUserInit(){
        this.userDao.appUserInit();
    }

    public boolean login(String userName, String password){
        return this.userDao.login(userName, password);
    }
}
