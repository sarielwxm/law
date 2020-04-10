package com.evan.login.service;

import com.evan.login.domain.User;
import com.evan.login.domain.UserMessage;
import com.evan.login.domain.UserMessagePojo;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author cai
 */
@Service
public interface UserService {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByName(String username);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 判断是否存在相同用户
     * @param username
     * @return
     */
    Boolean isExist(String username);

    /**
     * 注册用户
     * @param user
     * @return
     */
    Integer register(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer userId);

    List<UserMessagePojo> getUserList();
}
