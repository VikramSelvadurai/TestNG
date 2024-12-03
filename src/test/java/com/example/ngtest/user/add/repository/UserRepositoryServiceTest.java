package com.example.ngtest.user.add.repository;

import com.example.ngtest.user.add.enums.UserStatus;
import com.example.ngtest.user.add.request.UserRequestBean;
import com.example.ngtest.user.add.response.UserResponseBean;
import com.example.ngtest.user.add.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.Test;
//@DataJpaTest
//@TestPropertySource(properties = {
//        "spring.jpa.hibernate.ddl-auto=validate"
//})
//@RunWith(MockitoJUnitRunner.class) // Use MockitoJUnitRunner for injection
public class UserRepositoryServiceTest {

    private UserRepositoryService userRepositoryService;
//    @Autowired
//     UserService userService;
//
//    public UserRepositoryServiceTest(UserService userService) {
//        this.userService = userService;
//    }
//
    public UserRepositoryServiceTest(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

//    @Mock // Mockito annotation to mock the bean
//    private UserRepositoryService userRepositoryService;

    @Test
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test
    public void aSlowTest() {
        System.out.println("Slow test");
    }


    @Test
    public void addUser() {

//        UserRepositoryService userRepositoryService = Mockito.mock(UserRepositoryService.class);
//        Mockito.when(userRepositoryService.addUser(Mockito.any(UserRequestBean.class)))
//                .thenReturn(new UserResponseBean("username"));
//        userService = new UserService();

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
//        assertEquals(userResponseBean.getUsername(), "username");

    }
}