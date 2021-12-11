package com.ari.userTask.response;

import lombok.*;

/**
 * Created by Arittek-002 on 28/07/2021.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserResponse {

    private Integer id;

    private String username;
    private String firstName;
    private String lastName;
    private String cnic;
    private String email;
    private String phoneNo;
    private String address;
}
