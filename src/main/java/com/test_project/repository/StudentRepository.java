package com.test_project.repository;

import com.test_project.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);
}