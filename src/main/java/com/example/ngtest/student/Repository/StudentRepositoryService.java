package com.example.ngtest.student.Repository;

import com.example.ngtest.student.assembler.StudentAssembler;
import com.example.ngtest.student.entity.StudentEntity;
import com.example.ngtest.student.request.StudentRequestBean;
import com.example.ngtest.student.response.StudentResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentRepositoryService {

    private final StudentAssembler studentAssembler;
    private final StudentRepository studentRepository;

    public StudentResponseBean addStudent(StudentRequestBean studentRequestBean){
        StudentEntity studentEntity = StudentEntity.builder()
                .address(studentRequestBean.getAddress())
                .name(studentRequestBean.getName())
                .phoneNumber(studentRequestBean.getPhoneNumber())
                .department(studentRequestBean.getDepartment())
                .build();
        StudentEntity save = studentRepository.save(studentEntity);
        return studentAssembler.toModel(save);
    }
}
