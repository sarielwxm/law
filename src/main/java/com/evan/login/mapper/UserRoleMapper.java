package com.evan.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
