package com.example.ngtest.employee.service;

import com.example.ngtest.employee.assembler.EmployeeAssembler;
import com.example.ngtest.employee.entity.EmployeeEntity;
import com.example.ngtest.employee.exception.EmpIdNotFoundException;
import com.example.ngtest.employee.repository.EmployeeRepository;
import com.example.ngtest.employee.repository.EmployeeRepositoryService;
import com.example.ngtest.employee.request.EmployeeRequestBean;
import com.example.ngtest.employee.response.EmployeeResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl {
    private final EmployeeRepositoryService employeeRepositoryService;
    private final EmployeeRepository employeeRepository;
    private final EmployeeAssembler employeeAssembler;


    public EmployeeResponseBean addEmployee(EmployeeRequestBean employeeRequestBean) {
        return employeeRepositoryService.save(employeeRequestBean);
    }

    public EmployeeResponseBean updateEmployee(UUID empId, EmployeeRequestBean employeeRequestBean) throws EmpIdNotFoundException {
        EmployeeEntity employeeEntity = employeeRepositoryService.findById(empId);
        employeeEntity.setName(employeeRequestBean.getName());
        employeeEntity.setAddress(employeeRequestBean.getAddress());
        employeeEntity.setPhoneNumber(employeeRequestBean.getPhoneNumber());
        return employeeAssembler.toModel(employeeRepository.save(employeeEntity));
    }

    public String deleteEmployee(UUID empId) {
        employeeRepositoryService.deleteByEmployeeId(empId);
        return "Deleted successfully";
    }

    public EmployeeResponseBean getEmployee(UUID empId) throws EmpIdNotFoundException {
        return employeeAssembler.toModel(employeeRepositoryService.findById(empId));
    }
}
