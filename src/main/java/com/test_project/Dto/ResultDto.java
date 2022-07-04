package com.test_project.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultDto implements Serializable {
    private Long resultId;
    private Long studentRollNum;
    private String semester;
    private Long registrationNum;
    private Long courseCode;
    private String courseTitle;
    private Integer totalMarks;
    private Integer examMarks;
    private Integer obtainMarks;
    private String grade;
    private boolean status;

}
