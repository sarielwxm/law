package com.evan.login.dao;

import com.evan.login.pojo.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wxm
 * @date 2020/3
 */

public interface AdminRoleMenuDAO extends JpaRepository<AdminRoleMenu,Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
    void deleteAllByRid(int rid);
}