package com.example.ngtest;

import com.example.ngtest.user.add.enums.UserStatus;
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
class TestNGApplicationTests extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserRepositoryService userRepositoryService;



    @Test
    public void addUser() {

        UserRequestBean userRequestBean = UserRequestBean.builder()
                .userStatus(UserStatus.ACTIVE)
                .email("email@email.com")
                .password("password")
                .firstName("firstName")
                .lastName("lastName")
                .username("username")
                .build();
        UserResponseBean userResponseBean = userRepositoryService.addUser(userRequestBean);
        Assert.assertTrue(userResponseBean.getUsername().equals("username"));// assertNotNull(userResponseBean);
    }

}
