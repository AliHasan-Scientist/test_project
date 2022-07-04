package com.test_project.Repository;

import com.test_project.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);
}