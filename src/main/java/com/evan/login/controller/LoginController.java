package com.evan.login.controller;

import com.evan.login.domain.User;
import com.evan.login.mapper.UserMapper;
import com.evan.login.result.Result;
import com.evan.login.service.UserRoleService;
import com.evan.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
/**
 * @author cai
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User dbUser=userService.findByName(username);
        if (dbUser==null) {
            return new Result(601);
        }
        if(!requestUser.getPassword().equals(dbUser.getPassword())){
            return new Result(602);
        }
            Integer roleId=userRoleService.findRoleId(dbUser.getUserId());
            if(roleId==1){
                return new Result(201);
            }else if(roleId==2){
                return new Result(202);
            }else if(roleId==3){
                return new Result(203);
            }
                return new Result(200);


    }
    @CrossOrigin
    @PostMapping(value = "api/register")
    public Result register(@RequestBody User requestUser){
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        Boolean isExist=userService.isExist(username);
        if(isExist){
            return new Result(610);
        }
        Integer success=userService.register(requestUser);
        if(success==0){
            return new Result(611);
        }
        return new Result(200);
    }
}

