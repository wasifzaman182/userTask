package com.ari.userTask.service;

import com.ari.userTask.dto.LoginBean;
import com.ari.userTask.response.BaseResponse;
import com.ari.userTask.response.LoginResponse;
import org.springframework.stereotype.Service;

/**
 * Created by Arittek-002 on 29/07/2021.
 */

@Service
public interface LoginService {

    //login user
    public BaseResponse loginUser(LoginBean loginBean) throws Exception;
}
