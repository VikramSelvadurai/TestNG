package com.example.ngtest.student.service;

import com.example.ngtest.student.Repository.StudentRepositoryService;
import com.example.ngtest.student.request.StudentRequestBean;
import com.example.ngtest.student.response.StudentResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl {
    private final StudentRepositoryService studentRepositoryService;

    public StudentResponseBean addStudent(StudentRequestBean studentRequestBean) {
       return studentRepositoryService.addStudent(studentRequestBean);

    }
}
