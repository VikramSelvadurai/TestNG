package com.example.ngtest.user.add.controller;

import com.example.ngtest.user.add.UserIdNotFoundException;
import com.example.ngtest.user.add.repository.ResourceAlreadyExistException;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import com.example.ngtest.user.add.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-user")
    public UserResponseBean addUser(@RequestBody UserRequestBean userRequestBean) throws ResourceAlreadyExistException {
        return userService.addUser(userRequestBean);
    }
    @PatchMapping("/update-user/{userId}")
    public UserResponseBean updateUser(@PathVariable UUID userId, @RequestBody UserRequestBean userRequestBean) throws UserIdNotFoundException, ResourceAlreadyExistException {
        return userService.updateUser(userId,userRequestBean);
    }
    @DeleteMapping("/delete-user/{userId}")
    public String deleteUser(@PathVariable UUID userId) {
        return userService.deleteUser(userId);

    }
    @GetMapping("/get-user/{userId}")
    public UserResponseBean getUser(@PathVariable UUID userId) throws UserIdNotFoundException {
        return userService.getUserInfo(userId);
    }
}
