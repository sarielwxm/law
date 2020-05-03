package com.evan.login.service;


import com.evan.login.domain.Name;
import com.evan.login.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 更新用户角色
     * @param role
     * @return
     */
    Integer updateRole(Role role);

    /**
     * 给用户添加角色
     * @param uid
     * @return
     */
    Integer addRole(Integer uid);

    Integer deleteRole(Integer uid);

    List<Name> getRoleList();
}
