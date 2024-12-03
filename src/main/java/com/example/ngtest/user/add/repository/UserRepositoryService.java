package com.example.ngtest.user.add.repository;

import com.example.ngtest.user.add.assembler.UserAssembler;
import com.example.ngtest.user.add.entity.UserEntity;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryService {

    private final UserRepository userRepository;
    private final UserAssembler userAssembler;


    public UserResponseBean addUser(UserRequestBean userRequestBean) {

        UserEntity userEntity = UserEntity.builder()
                .username(userRequestBean.getUsername())
                .password(userRequestBean.getPassword())
                .userStatus(userRequestBean.getUserStatus())
                .email(userRequestBean.getEmail())
                .firstName(userRequestBean.getFirstName())
                .lastName(userRequestBean.getLastName())
                .build();
        userRepository.save(userEntity);

        return userAssembler.toModel(userEntity);
    }
}
