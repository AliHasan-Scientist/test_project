package com.test_project.services;

import com.test_project.dto.ResultDto;

import java.util.List;

public interface ResultService {
    // Add a new student
//    ResultDto addAResult(ResultDto resultDto);
    ResultDto addAResult(ResultDto resultDto ,Long studentId);


    //get All student
    List<ResultDto> getAllResults();

    // get Student By its id
    ResultDto getResultWithId(Long resultId);

    // update a student
    ResultDto updateResult(Long resultId);

    // delete a student
    void deleteResult(Long resultId);
}
