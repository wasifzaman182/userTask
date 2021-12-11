package com.ari.userTask.configuration;


import com.ari.userTask.jwt.jwtRequest.JwtRequest;
import com.ari.userTask.service.serviceImpl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Arittek-002 on 30/07/2021.
 */

@Component
public class JwatAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private JwtRequest jwtRequest;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("User name in request " + jwtRequest.getUsername());
        System.out.println("User password " + jwtRequest.getPassword());

        final String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        System.out.println(requestTokenHeader);

        String username =null;
        String jwtToken =null;

        if(requestTokenHeader !=null && requestTokenHeader.startsWith("Bearer ")){

            jwtToken = requestTokenHeader.substring(7);

            try{

                username = jwtUtils.extractUsername(jwtToken);
            }catch (ExpiredJwtException e){
                e.printStackTrace();
                System.out.println("Token Expired");
            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println("Error");
            }

        }
        else{
            System.out.println("Token is invalid, not starting with Bearer");
        }

        if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null){

            final UserDetails userDetails =  this.userDetailsService.loadUserByUsername(username);

            if(this.jwtUtils.validateToken(jwtToken,userDetails)){

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities() );
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else{
            System.out.println("Token is not valid");
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }

//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
//
//        return new AntPathMatcher().match("/user/create", request.getServletPath());
//    }
    }

