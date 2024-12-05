package com.example.ngtest.employee.repository;

import com.example.ngtest.employee.assembler.EmployeeAssembler;
import com.example.ngtest.employee.entity.EmployeeEntity;
import com.example.ngtest.employee.exception.EmpIdNotFoundException;
import com.example.ngtest.employee.request.EmployeeRequestBean;
import com.example.ngtest.employee.response.EmployeeResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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

    public EmployeeEntity findById(UUID empId) throws EmpIdNotFoundException {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(empId);
        return employeeEntityOptional.orElseThrow(() -> new EmpIdNotFoundException("'"+empId+"' Not Found"));
    }

    public void deleteByEmployeeId(UUID empId) {
        employeeRepository.deleteById(empId);
    }
}
