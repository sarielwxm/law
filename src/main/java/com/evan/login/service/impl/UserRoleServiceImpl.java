package com.evan.login.service.impl;

import com.evan.login.domain.Name;
import com.evan.login.domain.Role;
import com.evan.login.mapper.UserRoleMapper;
import com.evan.login.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public Integer findRoleId(Integer uid) {
        return userRoleMapper.findRoleId(uid);
    }

    @Override
    public Integer updateRole(Role role) {
        return userRoleMapper.updateRoleId(role);
    }

    @Override
    public Integer addRole(Integer uid) {
        return userRoleMapper.addRole(uid);
    }

    @Override
    public Integer deleteRole(Integer uid) {
        return userRoleMapper.deleteRole(uid);
    }

    @Override
    public List<Name> getRoleList() {
        return userRoleMapper.getRoleList();
    }


}
