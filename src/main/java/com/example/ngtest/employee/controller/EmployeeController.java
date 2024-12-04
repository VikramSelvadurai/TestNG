package com.example.ngtest.employee.controller;

import com.example.ngtest.employee.request.EmployeeRequestBean;
import com.example.ngtest.employee.response.EmployeeResponseBean;
import com.example.ngtest.employee.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;


    @RequestMapping("/add")
    public EmployeeResponseBean add(@RequestBody EmployeeRequestBean employeeRequestBean) {
        return employeeService.addEmployee(employeeRequestBean);
    }
}
