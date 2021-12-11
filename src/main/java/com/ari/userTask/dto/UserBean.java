package com.ari.userTask.dto;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * Created by Arittek-002 on 28/07/2021.
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class UserBean {

    private String username;
    private String firstName;
    private String lastName;
    private String cnic;
    private String email;
    private String phoneNo;
    private String address;
    private String password;

}
