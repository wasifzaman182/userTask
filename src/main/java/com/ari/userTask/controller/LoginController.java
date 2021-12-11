package com.ari.userTask.controller;

import com.ari.userTask.dto.LoginBean;
import com.ari.userTask.response.BaseResponse;
import com.ari.userTask.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arittek-002 on 29/07/2021.
 */

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginService loginService;


    @GetMapping("/user")
    public BaseResponse loginUser(@RequestBody LoginBean loginBean) throws Exception{
        return loginService.loginUser(loginBean);
    }
}
