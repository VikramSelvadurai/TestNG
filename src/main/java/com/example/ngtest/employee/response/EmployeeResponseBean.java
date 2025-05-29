package com.example.ngtest.employee.response;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeResponseBean extends RepresentationModel<EmployeeResponseBean> {
    private UUID employeeId;
    private String name;
    private String address;
    private String phoneNumber;
}
