package com.test_project.Repository;

import com.test_project.Entities.ResultCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultCardRepository extends JpaRepository<ResultCard, Long> {
    List<ResultCard> findByUniversityNameAndStudentFirstName(String universityName, String student_firstName);
}