package com.evan.login.service.impl;

import com.evan.login.domain.User;
import com.evan.login.domain.UserMessage;
import com.evan.login.domain.UserMessagePojo;
import com.evan.login.mapper.UserMapper;
import com.evan.login.mapper.UserRoleMapper;
import com.evan.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cai
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
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

    @Override
    public Integer updateUser(User user) {
        user.setGmtModified(LocalDateTime.now());
        return userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public List<UserMessagePojo> getUserList() {
        List<UserMessage> userMessages=userMapper.getUserList();
        List<UserMessagePojo> list=new ArrayList<>();
        System.out.println(userMessages.size());
        for(int i=0;i<userMessages.size();i++){
            UserMessagePojo userMessagePojo=new UserMessagePojo();
           userMessagePojo.setUserId(userMessages.get(i).getUserId());
           userMessagePojo.setAvatar(userMessages.get(i).getAvatar());
           userMessagePojo.setBirthday(userMessages.get(i).getBirthday());
           userMessagePojo.setUsername(userMessages.get(i).getUsername());
           userMessagePojo.setGender(userMessages.get(i).getGender());
           userMessagePojo.setEmail(userMessages.get(i).getEmail());
           userMessagePojo.setMobile(userMessages.get(i).getMobile());
           Integer roleId=userRoleMapper.findRoleId(userMessages.get(i).getUserId());
           String s=null;
           if(roleId==0){
               s="普通用户";
           }else if(roleId==2){
               s="法务工作者";
           }else if(roleId==3){
               s="政府工作人员";
           }else if(roleId==1){
               s="管理员";
           }
           userMessagePojo.setRoles(s);
           list.add(userMessagePojo);
        }
        return list;
    }
}
