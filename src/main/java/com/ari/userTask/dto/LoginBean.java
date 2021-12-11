package com.ari.userTask.dto;

import lombok.*;

/**
 * Created by Arittek-002 on 29/07/2021.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginBean {

    private String username;
    private String password;
}
