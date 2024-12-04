package com.example.ngtest.user.add.repository;

import com.example.ngtest.user.add.enums.UserStatus;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
//@SpringBootTest
public class UserRepositoryServiceTest extends AbstractTestNGSpringContextTests {

    private final UserRepositoryService userRepositoryService;

    public UserRepositoryServiceTest(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }


    @Test
    public void addUser() {

        UserRequestBean userRequestBean = UserRequestBean.builder()
                .userStatus(UserStatus.ACTIVE)
                .email("email@email.com")
                .password("password")
                .firstName("firstName")
                .lastName("lastName")
                .username("signintets")
                .build();
        UserResponseBean userResponseBean = userRepositoryService.addUser(userRequestBean);
        Assert.assertTrue(userResponseBean.getUsername().equals("signintets"));// assertNotNull(userResponseBean);
    }

}