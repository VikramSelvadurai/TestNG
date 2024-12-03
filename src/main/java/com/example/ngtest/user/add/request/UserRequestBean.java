package com.example.ngtest.user.add.request;

import com.example.ngtest.user.add.enums.UserStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRequestBean {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus userStatus;
}
