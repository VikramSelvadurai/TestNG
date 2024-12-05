package com.example.ngtest.employee.controller;

import com.example.ngtest.employee.exception.EmpIdNotFoundException;
import com.example.ngtest.employee.request.EmployeeRequestBean;
import com.example.ngtest.employee.response.EmployeeResponseBean;
import com.example.ngtest.employee.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;


    @PostMapping("/add")
    public EmployeeResponseBean add(@RequestBody EmployeeRequestBean employeeRequestBean) {
        return employeeService.addEmployee(employeeRequestBean);
    }
    @PatchMapping("/update/{empId}")
    public EmployeeResponseBean update(@PathVariable UUID empId, @RequestBody EmployeeRequestBean employeeRequestBean) throws EmpIdNotFoundException {
        return employeeService.updateEmployee(empId,employeeRequestBean);
    }
    @DeleteMapping("/delete/{empId}")
    public String delete(@PathVariable UUID empId) {
        return employeeService.deleteEmployee(empId);
    }

    @GetMapping("/get/{empId}")
    public EmployeeResponseBean get(@PathVariable UUID empId) throws EmpIdNotFoundException {
        return employeeService.getEmployee(empId);
    }

}
