package com.test_project.dto;

import com.test_project.entities.Result;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<ResultDto> result=new ArrayList<>();

}
