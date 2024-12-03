package com.example.ngtest.user.add.service;

import com.example.ngtest.user.add.repository.UserRepositoryService;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepositoryService userRepositoryService;

    public UserService(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    public UserResponseBean addUser(UserRequestBean userRequestBean) {
        return userRepositoryService.addUser(userRequestBean);
    }
}



