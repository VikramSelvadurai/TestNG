package com.example.ngtest.student.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StudentRequestBean {

    private String name;
    private String address;
    private String phoneNumber;
    private String department;
}
