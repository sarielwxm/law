package com.evan.login.controller;

import com.evan.login.domain.User;
import com.evan.login.result.Result;
import com.evan.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
/**
 * @author cai
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
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
            return new Result(200);

    }
}

