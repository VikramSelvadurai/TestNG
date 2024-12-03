package com.example.ngtest.user.add.controller;

import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import com.example.ngtest.user.add.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserLoginController {

    private final UserService userService;


    @PostMapping(value = "/add-user")
    public UserResponseBean addUser(@RequestBody UserRequestBean userRequestBean) {
        return userService.addUser(userRequestBean);
    }

}
