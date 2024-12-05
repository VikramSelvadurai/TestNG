package com.example.ngtest.student.service;

import com.example.ngtest.student.Repository.StudentRepositoryService;
import com.example.ngtest.student.assembler.StudentAssembler;
import com.example.ngtest.student.entity.StudentEntity;
import com.example.ngtest.student.exception.StudentIdNotFoundException;
import com.example.ngtest.student.request.StudentRequestBean;
import com.example.ngtest.student.response.StudentResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl {
    private final StudentRepositoryService studentRepositoryService;
    private final StudentAssembler studentAssembler;

    public StudentResponseBean addStudent(StudentRequestBean studentRequestBean) {
       return studentRepositoryService.addStudent(studentRequestBean);
    }

    public StudentResponseBean updateStudent(UUID studId, StudentRequestBean studentRequestBean) throws StudentIdNotFoundException {
        StudentEntity studentEntity = studentRepositoryService.findById(studId);
        studentEntity.setName(studentRequestBean.getName());
        studentEntity.setAddress(studentRequestBean.getAddress());
        studentEntity.setDepartment(studentRequestBean.getDepartment());
        studentEntity.setPhoneNumber(studentRequestBean.getPhoneNumber());
        return studentAssembler.toModel(studentEntity);
    }

    public String deleteStudent(UUID studId) {
        studentRepositoryService.deleteById(studId);
        return "Student info deleted successfully";
    }

    public StudentResponseBean getStudentInfo(UUID studId) throws StudentIdNotFoundException {
        return studentAssembler.toModel(studentRepositoryService.findById(studId));
    }
}
