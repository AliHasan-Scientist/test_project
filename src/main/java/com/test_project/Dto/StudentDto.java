package com.test_project.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String studentAddress;
    private String email;
    private String studentPassword;

}
