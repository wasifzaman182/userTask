package com.ari.userTask.service.serviceImpl;

import com.ari.userTask.dto.UserBean;
import com.ari.userTask.model.UserEntity;
import com.ari.userTask.repository.UserEntityRepository;
import com.ari.userTask.response.BaseResponse;
import com.ari.userTask.response.UserResponse;
import com.ari.userTask.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Arittek-002 on 27/07/2021.
 */

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

 //create new user
    @Override
    public BaseResponse createUser(UserBean userBean) throws Exception {

        UserEntity user = new UserEntity();

       UserEntity userCreate =  userEntityRepository.findByUsername(userBean.getUsername());
       //System.out.println(userBean.getUsername());

       if(userCreate!=null) {
           System.out.println("Username exist");
            throw new Exception("Username already exist");

       }

       else {
           System.out.println("Creating new user");

           user.setUsername(userBean.getUsername());
           user.setFirstName(userBean.getFirstName());
           user.setLastName(userBean.getLastName());
           user.setCnic(userBean.getCnic());
           user.setPhoneNo(userBean.getPhoneNo());
           user.setEmail(userBean.getEmail());
           user.setAddress(userBean.getAddress());
           //user.setPassword(bCryptPasswordEncoder.encode(userBean.getPassword()));
           user.setPassword(userBean.getPassword());

           userEntityRepository.save(user);
         BaseResponse baseResponse = BaseResponse.builder().responseMessage("Success").responseObject(user).build();
         return baseResponse;
       }

    }

    //get user by id
    @Override
    public BaseResponse getUser(String username) {

       UserEntity getUserByName = userEntityRepository.findByUsername(username);

       BaseResponse baseResponse = BaseResponse.builder().responseMessage("Success").responseObject(getUserByName).build();
        return baseResponse;
    }


    //get all user
    @Override
    public BaseResponse getAllUser() {

        UserResponse userResponse = new UserResponse();
      //  List<UserEntity> response  = new ArrayList<>();

        List<UserEntity> userEntityList = userEntityRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            userResponseList.add(UserResponse.builder().id(userEntity.getId())
                    .email(userEntity.getEmail())
                    .address(userEntity.getAddress())
                    .cnic(userEntity.getCnic())
                    .firstName(userEntity.getFirstName())
                    .lastName(userEntity.getLastName())
                    .phoneNo(userEntity.getPhoneNo())
                    .username(userEntity.getUsername())
                    .build());

        }

        BaseResponse baseResponse = BaseResponse.builder().responseMessage("Success").responseCode("").responseObject(userResponseList).build();

        return baseResponse;
    }


    @Override
    public BaseResponse updateUser(UserBean userBean) throws  Exception {

        //UserEntity user = new UserEntity();
        UserEntity findUser=null;

        if(StringUtils.isNotEmpty(userBean.getUsername())){
            findUser = userEntityRepository.findByUsername(userBean.getUsername());
        }

        if(findUser != null){

            if(StringUtils.isNotEmpty(userBean.getFirstName()))
                findUser.setFirstName(userBean.getFirstName());
            if(StringUtils.isNotEmpty(userBean.getLastName()))
                findUser.setLastName(userBean.getLastName());
            if(StringUtils.isNotEmpty(userBean.getAddress()))
                findUser.setAddress(userBean.getAddress());
            if (StringUtils.isNotEmpty(userBean.getCnic()))
                findUser.setCnic(userBean.getCnic());
            if (StringUtils.isNotEmpty(userBean.getPhoneNo()))
                findUser.setPhoneNo(userBean.getPhoneNo());
            if (StringUtils.isNotEmpty(userBean.getEmail()))
                findUser.setEmail(userBean.getEmail());

            findUser.setUsername(userBean.getUsername());
            userEntityRepository.save(findUser);

          BaseResponse  baseResponse = BaseResponse.builder().responseMessage("Success").responseObject(findUser).build();

            return baseResponse;
        }

        else{
            throw new Exception("User not found to update");
        }


    }

    @Override
    public BaseResponse deleteUser(Integer id) throws Exception {

        String uId = Integer.toString(id);

        if (StringUtils.isNotEmpty(uId)){

            userEntityRepository.deleteById(id);
            BaseResponse baseResponse =BaseResponse.builder().responseMessage("User Deleted Successfully").build();
            return baseResponse;
        }
        else {
            throw new Exception("User Id is null");
        }

    }


}
