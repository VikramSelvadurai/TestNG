package com.example.ngtest.user.add.service;


import com.example.ngtest.user.add.enums.UserStatus;
import com.example.ngtest.user.add.repository.ResourceAlreadyExistException;
import com.example.ngtest.user.add.repository.UserRepositoryService;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepositoryService userRepositoryService;


    @Test
    public void adduser() throws ResourceAlreadyExistException {
        UserRequestBean userRequestBean = UserRequestBean.builder()
                .userStatus(UserStatus.ACTIVE)
                .email("email@email.com")
                .password("password")
                .firstName("firstName")
                .lastName("lastName")
                .username("vikramsuriya")
                .build();
        UserResponseBean userResponseBean = userService.addUser(userRequestBean);
        Assert.assertTrue(userResponseBean.getUsername().equals("vikramsuriya"));

    }


}