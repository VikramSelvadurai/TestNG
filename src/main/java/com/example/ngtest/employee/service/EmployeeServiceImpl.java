package com.example.ngtest.employee.service;

import com.example.ngtest.employee.repository.EmployeeRepositoryService;
import com.example.ngtest.employee.request.EmployeeRequestBean;
import com.example.ngtest.employee.response.EmployeeResponseBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl {
    private final EmployeeRepositoryService employeeRepositoryService;


    public EmployeeResponseBean addEmployee(EmployeeRequestBean employeeRequestBean) {
        return employeeRepositoryService.save(employeeRequestBean);
    }

}
