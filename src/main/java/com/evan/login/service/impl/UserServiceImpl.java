package com.evan.login.service.impl;

import com.evan.login.domain.User;
import com.evan.login.mapper.UserMapper;
import com.evan.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author cai
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public Boolean isExist(String username) {
        if(userMapper.findByName(username)==null){
            return false;
        }
        return true;
    }

    @Override
    public Integer register(User user) {
        user.setGmtCreate(LocalDateTime.now());
        user.setGmtModified(LocalDateTime.now());
        return userMapper.addUser(user);
    }
}
