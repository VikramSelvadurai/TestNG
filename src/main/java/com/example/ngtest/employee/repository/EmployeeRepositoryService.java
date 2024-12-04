package com.example.ngtest.employee.repository;

import com.example.ngtest.employee.assembler.EmployeeAssembler;
import com.example.ngtest.employee.entity.EmployeeEntity;
import com.example.ngtest.employee.request.EmployeeRequestBean;
import com.example.ngtest.employee.response.EmployeeResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeAssembler employeeAssembler;


    public EmployeeResponseBean save(EmployeeRequestBean employeeRequestBean) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .address(employeeRequestBean.getAddress())
                .name(employeeRequestBean.getName())
                .phoneNumber(employeeRequestBean.getPhoneNumber())
                .build();
        EmployeeEntity save = employeeRepository.save(employeeEntity);
        return employeeAssembler.toModel(save);
    }
}
