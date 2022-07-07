package com.test_project.dto;

import com.test_project.entities.Result;
import com.test_project.entities.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data

public class ResultCardDto {
    private Long resultResultId;
    private String universityName;
    private String image;
    private Date announcedDate;
    private Student student;
    private Result result;

}
