package com.example.ngtest.student.controller;

import com.example.ngtest.student.exception.StudentIdNotFoundException;
import com.example.ngtest.student.request.StudentRequestBean;
import com.example.ngtest.student.response.StudentResponseBean;
import com.example.ngtest.student.service.StudentServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @PostMapping("/add")
    public StudentResponseBean addStudent(@RequestBody StudentRequestBean studentRequestBean){
        return studentService.addStudent(studentRequestBean);
    }
    @PatchMapping("/update/{studId}")
    public StudentResponseBean updateStudent(@PathVariable UUID studId, @RequestBody StudentRequestBean studentRequestBean) throws StudentIdNotFoundException {
        return studentService.updateStudent(studId,studentRequestBean);
    }

    @DeleteMapping("/delete/{studId}")
    public String deleteStudent(@PathVariable UUID studId){
        return studentService.deleteStudent(studId);
    }

    @GetMapping("/get/{studId}")
    public StudentResponseBean getStudent(@PathVariable UUID studId) throws StudentIdNotFoundException {
        return studentService.getStudentInfo(studId);
    }
}
