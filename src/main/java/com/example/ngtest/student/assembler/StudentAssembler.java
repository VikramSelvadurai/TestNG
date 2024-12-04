package com.example.ngtest.student.assembler;

import com.example.ngtest.student.entity.StudentEntity;
import com.example.ngtest.student.response.StudentResponseBean;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class StudentAssembler implements RepresentationModelAssembler<StudentEntity,StudentResponseBean> {


    @Override
    public StudentResponseBean toModel(StudentEntity entity) {
        return buildModel(entity);
    }

    private StudentResponseBean buildModel(StudentEntity entity) {
        return StudentResponseBean.builder()
                .studentId(entity.getId())
                .address(entity.getAddress())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .department(entity.getDepartment())
                .build();

    }

    @Override
    public CollectionModel<StudentResponseBean> toCollectionModel(Iterable<? extends StudentEntity> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
