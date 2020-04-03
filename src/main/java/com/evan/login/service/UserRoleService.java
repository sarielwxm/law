package com.evan.login.service;


import org.springframework.stereotype.Service;
/**
 * @author cai
 */
@Service
public interface UserRoleService {
    /**
     * 根据用户id查询roleId
     * @param uid
     * @return
     */
    Integer findRoleId(Integer uid);
}
