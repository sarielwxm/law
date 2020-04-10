package com.evan.login.mapper;

import com.evan.login.domain.User;
import com.evan.login.domain.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cai
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findByName(String username);

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 注册新用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 根据userid删除用户
     * @param userId
     * @return
     */
    Integer deleteUser(Integer userId);

    List<UserMessage> getUserList();
}
