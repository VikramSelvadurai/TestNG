package com.example.ngtest.user.add.response;

import com.example.ngtest.user.add.enums.UserStatus;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class UserResponseBean extends RepresentationModel<UserResponseBean> {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus userStatus;
}
