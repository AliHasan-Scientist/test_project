package com.test_project.Services;


import com.test_project.Dto.StudentDto;
import com.test_project.Entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    // Add a new student
    StudentDto addAStudent(StudentDto studentDto);

    //get All student
    List<StudentDto> getAllStudents();

    // get Student By its id
    StudentDto getStudentWithId(Long studentId);

    // update a student
    StudentDto updateStudent(StudentDto studentDto, Long studentId);

    // delete a student
    StudentDto deleteStudent(Long studentId);

    //find student byName
    List<Student> findStudentByFirstName(String student);

}
