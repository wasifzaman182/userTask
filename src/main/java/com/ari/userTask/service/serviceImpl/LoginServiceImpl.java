package com.ari.userTask.service.serviceImpl;

import com.ari.userTask.dto.LoginBean;
import com.ari.userTask.model.UserEntity;
import com.ari.userTask.repository.UserEntityRepository;
import com.ari.userTask.response.BaseResponse;
import com.ari.userTask.response.LoginResponse;
import com.ari.userTask.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Arittek-002 on 29/07/2021.
 */

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public BaseResponse loginUser(LoginBean loginBean) throws Exception {

        LoginResponse loginResponse = new LoginResponse();

       if (StringUtils.isNotEmpty(loginBean.getUsername()) && StringUtils.isNotEmpty(loginBean.getPassword())) {

           UserEntity userLogin = userEntityRepository.findByUsername(loginBean.getUsername());

           if(userLogin !=null){

               loginResponse.setId(userLogin.getId());
               loginResponse.setUsername(userLogin.getUsername());
               loginResponse.setEmail(userLogin.getEmail());
               loginResponse.setPassword(userLogin.getPassword());
               loginResponse.setPhoneNo(userLogin.getPhoneNo());
               loginResponse.setAddress(userLogin.getAddress());
               loginResponse.setCnic(userLogin.getCnic());
               loginResponse.setFirstName(userLogin.getFirstName());
               loginResponse.setLastName(userLogin.getLastName());

               BaseResponse baseResponse = BaseResponse.builder().responseMessage("Success").responseCode("000").responseObject(loginResponse).build();
               return baseResponse;
           }
       }

       BaseResponse baseResponse = BaseResponse.builder().responseMessage("Username or password is incorrect").build();
       return baseResponse;
    }
}
