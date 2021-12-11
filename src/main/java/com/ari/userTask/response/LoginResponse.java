package com.ari.userTask.response;

import lombok.*;

/**
 * Created by Arittek-002 on 29/07/2021.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String cnic;
    private String email;
    private String phoneNo;
    private String address;
    private String password;
}
