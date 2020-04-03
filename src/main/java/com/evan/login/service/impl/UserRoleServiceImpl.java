package com.evan.login.service.impl;

import com.evan.login.mapper.UserRoleMapper;
import com.evan.login.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public Integer findRoleId(Integer uid) {
        return userRoleMapper.findRoleId(uid);
    }
}
