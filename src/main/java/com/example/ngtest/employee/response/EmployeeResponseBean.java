package com.example.ngtest.employee.response;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class EmployeeResponseBean extends RepresentationModel<EmployeeResponseBean> {
    private UUID employeeId;
    private String name;
    private String address;
    private String phoneNumber;
}
