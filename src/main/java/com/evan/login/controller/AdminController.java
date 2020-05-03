package com.evan.login.controller;

import com.evan.login.domain.*;
import com.evan.login.result.Result;
import com.evan.login.service.UserRoleService;
import com.evan.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @CrossOrigin
    @PutMapping("api/admin/user")
    public Result updateUser(@RequestBody UserPojo userPojo){
        User user=new User();
        user.setUserId(userPojo.getUserId());
        user.setUsername(userPojo.getUsername());
        user.setEmail(userPojo.getEmail());
        user.setMobile(userPojo.getPhone());
        String roles=userPojo.getRoles();
        int roleId=0;
        if(roles.equals("法务工作者")){
            roleId=2;
        }else if(roles.equals("政府工作人员")) {
            roleId = 3;
        }
        Role role=new Role();
        role.setUid(user.getUserId());
        role.setRid(roleId);
        Integer a=userService.updateUser(user);
        Integer b=userRoleService.updateRole(role);
        if(a!=0&&b!=0) {
            return new Result(200);
        }
        return new Result(501);//更新失败
    }

    @CrossOrigin
    @DeleteMapping("api/admin/user")
    public Result deleteUser(@RequestParam Integer userId){
        Integer a=userService.deleteUser(userId);
        Integer b=userRoleService.deleteRole(userId);
        if(a!=0&&b!=0) {
            return new Result(200);
        }
        return new Result(502);//删除失败
    }

    @CrossOrigin
    @GetMapping("api/admin/user")
    public List<UserMessagePojo> getUserList(){
        return userService.getUserList();

    }

    @CrossOrigin
    @GetMapping("api/admin/role")
    public List<Name> getRoleList(){
        return userRoleService.getRoleList();
    }
}
