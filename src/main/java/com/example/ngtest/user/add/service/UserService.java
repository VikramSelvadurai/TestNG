package com.example.ngtest.user.add.service;

import com.example.ngtest.user.add.repository.UserRepositoryService;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoryService userRepositoryService;

    public UserResponseBean addUser(UserRequestBean userRequestBean) {
        return userRepositoryService.addUser(userRequestBean);
    }
}



