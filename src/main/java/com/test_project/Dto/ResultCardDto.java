package com.test_project.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResultCardDto {
    private Long resultResultId;
    private String universityName;
    private String image;
    private Date announcedDate;
}
