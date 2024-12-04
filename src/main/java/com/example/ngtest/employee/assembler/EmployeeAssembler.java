package com.example.ngtest.employee.assembler;

import com.example.ngtest.employee.entity.EmployeeEntity;
import com.example.ngtest.employee.response.EmployeeResponseBean;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAssembler implements RepresentationModelAssembler<EmployeeEntity, EmployeeResponseBean> {
    @Override
    public EmployeeResponseBean toModel(EmployeeEntity entity) {

        return buildModel(entity);
    }

    private EmployeeResponseBean buildModel(EmployeeEntity entity) {
        return EmployeeResponseBean.builder()
                .name(entity.getName())
                .employeeId(entity.getId())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .build();

    }


    @Override
    public CollectionModel<EmployeeResponseBean> toCollectionModel(Iterable<? extends EmployeeEntity> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
