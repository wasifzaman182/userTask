package com.ari.userTask.service;

import com.ari.userTask.dto.UserBean;
import com.ari.userTask.model.UserEntity;
import com.ari.userTask.response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Arittek-002 on 27/07/2021.
 */

@Service
public interface UserService {

    //create new user
    public BaseResponse createUser(UserBean userBean) throws Exception;

    //get user by id
    public BaseResponse getUser(String username);

    //get all user
    public  BaseResponse getAllUser();

    //update user
    public BaseResponse updateUser(UserBean userBean) throws Exception;

    //delete user
    public BaseResponse deleteUser(Integer id) throws Exception;
}
