package com.example.ngtest.student.controller;

import com.example.ngtest.student.request.StudentRequestBean;
import com.example.ngtest.student.response.StudentResponseBean;
import com.example.ngtest.student.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @PostMapping("/add")
    private StudentResponseBean addStudent(@RequestBody StudentRequestBean studentRequestBean){
        return studentService.addStudent(studentRequestBean);
    }
}
