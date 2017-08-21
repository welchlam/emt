package com.welch.emt.repository;

import com.welch.emt.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrator on 2017-6-4.
 */
public interface UserRepository extends CrudRepository <User, Long>{
    public List<User> findByUserName(String userName);
}
