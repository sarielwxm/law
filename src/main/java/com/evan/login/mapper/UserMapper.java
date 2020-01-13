package com.evan.login.mapper;

import com.evan.login.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
