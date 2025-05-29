package com.example.ngtest.student.Repository;

import com.example.ngtest.student.request.StudentRequestBean;
import com.example.ngtest.student.response.StudentResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
@SpringBootTest
public class StudentRepositoryServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StudentRepositoryService studentRepositoryService;

    @Test
    public void testAddStudent() {

        StudentRequestBean studentRequestBean = StudentRequestBean.builder()
                .name("vikramTest")
                .address("selliyamamnkovil street")
                .phoneNumber("4632095823057")
                .department("Developer")
                .build();
        StudentResponseBean studentResponseBean = studentRepositoryService.addStudent(studentRequestBean);
        Assert.assertEquals(studentRequestBean.getName(), studentResponseBean.getName());

    }
}