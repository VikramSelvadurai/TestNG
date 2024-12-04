package com.example.ngtest.employee.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeRequestBean {

    private String name;
    private String address;
    private String phoneNumber;
}
