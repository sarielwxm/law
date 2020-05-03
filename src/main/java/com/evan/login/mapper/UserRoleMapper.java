package com.evan.login.mapper;

import com.evan.login.domain.Name;
import com.evan.login.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cai
 */
@Repository
@Mapper
public interface UserRoleMapper {
    /**
     * 根据userId查询roleId
     * @param uid
     * @return
     */
    Integer findRoleId(Integer uid);

    /**
     * 给注册的新用户添加角色
     * @param uid
     * @return
     */
    Integer addRole(Integer uid);

    /**
     * 根据userId更新用户角色
     * @param role
     * @return
     */
    Integer updateRoleId(Role role);

    /**
     * 根据用户id删除角色
     * @param uid
     * @return
     */
    Integer deleteRole(Integer uid);

    List<Name> getRoleList();
}
