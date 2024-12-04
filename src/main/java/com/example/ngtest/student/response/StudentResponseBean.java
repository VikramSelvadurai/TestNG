package com.example.ngtest.student.response;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StudentResponseBean extends RepresentationModel<StudentResponseBean> {
    private UUID studentId;
    private String name;
    private String address;
    private String phoneNumber;
    private String department;
}
