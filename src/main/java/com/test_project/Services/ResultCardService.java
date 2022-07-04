package com.test_project.Services;

import com.test_project.Entities.ResultCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultCardService {
    ResultCard createAResultCard(Long studentId, Long resultId, ResultCard resultCard);

    List<ResultCard> getAllResultCards();
    List<ResultCard> findByUniversityNameAndStudentFirstName(String universityName, String student_firstName);
}
