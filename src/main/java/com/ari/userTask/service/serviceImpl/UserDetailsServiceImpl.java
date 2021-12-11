package com.ari.userTask.service.serviceImpl;

import com.ari.userTask.model.UserEntity;
import com.ari.userTask.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Arittek-002 on 30/07/2021.
 */

@Component
public class UserDetailsServiceImpl  implements UserDetailsService{

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserEntity userEntity = userEntityRepository.findByUsername(s);

        if (userEntity ==null){
            throw new UsernameNotFoundException("User not found");
        }
        return userEntity;
    }
}
