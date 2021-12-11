package com.ari.userTask.controller;

import com.ari.userTask.dto.UserBean;
import com.ari.userTask.model.UserEntity;
import com.ari.userTask.response.BaseResponse;
import com.ari.userTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Arittek-002 on 27/07/2021.
 */

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public BaseResponse createNewUser(@RequestBody UserBean userBean) throws Exception{
       return userService.createUser(userBean);

    }

    @GetMapping("/{username}")
    public BaseResponse getUserByName(@RequestBody @PathVariable("username") String username){
       return  userService.getUser(username);
    }


    @GetMapping("/all")
    public BaseResponse getAllUser(){
        return  userService.getAllUser();

    }

    @PutMapping("/update")
    public BaseResponse updateUser(@RequestBody UserBean userBean ) throws Exception{
        return userService.updateUser(userBean);

    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteUser(@PathVariable("id") Integer id) throws Exception {
      return   userService.deleteUser(id);
    }
}
