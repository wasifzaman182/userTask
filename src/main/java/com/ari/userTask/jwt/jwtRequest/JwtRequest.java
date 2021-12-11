package com.ari.userTask.jwt.jwtRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by Arittek-002 on 30/07/2021.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonIgnoreProperties
public class JwtRequest {

    private String username;
    private String password;
    private String role="USER";

}
