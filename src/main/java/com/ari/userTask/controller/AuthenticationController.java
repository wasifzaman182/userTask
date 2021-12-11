package com.ari.userTask.controller;

import com.ari.userTask.configuration.JwtUtils;
import com.ari.userTask.jwt.jwtRequest.JwtRequest;
import com.ari.userTask.jwt.jwtRequest.jwtResponse.JwtResponse;
import com.ari.userTask.model.UserEntity;
import com.ari.userTask.service.serviceImpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by Arittek-002 on 30/07/2021.
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    //generate token

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try{

            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());


        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Username not found ");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token =  this.jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username,String password) throws Exception {

        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));


        }catch (DisabledException e){

            throw new Exception("User Disabled " + e.getMessage());

        }catch (BadCredentialsException ex){

            throw new Exception("Bad Credentials " + ex.getMessage());
        }

    }

    //method which will return current user

    @GetMapping("/current-user")
    public UserEntity getCurrentUser(Principal principal){
        return ((UserEntity) this.userDetailsService.loadUserByUsername(principal.getName()));
    }
}
