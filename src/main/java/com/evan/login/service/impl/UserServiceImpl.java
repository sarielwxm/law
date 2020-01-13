package com.evan.login.service.impl;

import com.evan.login.domain.User;
import com.evan.login.mapper.UserMapper;
import com.evan.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
