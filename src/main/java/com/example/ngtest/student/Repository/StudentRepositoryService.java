package com.example.ngtest.student.Repository;

import com.example.ngtest.student.assembler.StudentAssembler;
import com.example.ngtest.student.entity.StudentEntity;
import com.example.ngtest.student.exception.StudentIdNotFoundException;
import com.example.ngtest.student.request.StudentRequestBean;
import com.example.ngtest.student.response.StudentResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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

    public StudentEntity findById(UUID studId) throws StudentIdNotFoundException {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studId);
        return studentEntityOptional.orElseThrow(() -> new StudentIdNotFoundException("'"+studId+"' Not Found"));

    }

    public void deleteById(UUID studId) {
        studentRepository.deleteById(studId);
    }
}
