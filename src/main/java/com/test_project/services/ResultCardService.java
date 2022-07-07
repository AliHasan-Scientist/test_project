package com.test_project.services;

import com.test_project.dto.ResultCardDto;
import com.test_project.entities.ResultCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultCardService {
    ResultCardDto createAResultCard(Long studentId, Long resultId, ResultCardDto resultCardDto);

    List<ResultCard> getAllResultCards();
    List<ResultCard> findByUniversityNameAndStudentFirstName(String universityName, String student_firstName);
}
