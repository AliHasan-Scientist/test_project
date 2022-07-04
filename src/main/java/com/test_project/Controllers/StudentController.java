package com.test_project.Controllers;

import com.test_project.Dto.StudentDto;
import com.test_project.Entities.Student;
import com.test_project.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("student/add")
    public ResponseEntity<StudentDto> createUser(@RequestBody StudentDto studentDto) {
        StudentDto studentDt = studentService.addAStudent(studentDto);
        return (new ResponseEntity<>(studentDt, HttpStatus.CREATED));
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<StudentDto>> getAllResults() {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        return new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }

    @GetMapping("/studentName/{studentName}")
    public ResponseEntity<List<Student>> findStudentByFirstName(@PathVariable(value = "studentName") String studentName) {
        List<Student> fetchedName = studentService.findStudentByFirstName(studentName);
        return new ResponseEntity<>(fetchedName, HttpStatus.OK);
    }

    @GetMapping(value = "getStudent/{studId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(value = "studId") Long studId) {
        if (studId == null) {
            return null;
        }
        StudentDto studentDto = this.studentService.getStudentWithId(studId);
        return new ResponseEntity<>(studentDto, HttpStatus.FOUND);
    }

    @PutMapping("update/{studentId}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto, @PathVariable(value = "studentId") Long studentId) {
        StudentDto updatedStudent = this.studentService.updateStudent(studentDto, studentId);
        return ResponseEntity.ok(updatedStudent).getBody();
    }

    @DeleteMapping("delete/{studentId}")
    public StudentDto updateStudent(@PathVariable(value = "studentId") Long studentId) {
        if (studentId == null) {
            return null;
        }
        StudentDto updatedStudent = this.studentService.deleteStudent(studentId);
        return ResponseEntity.ok(updatedStudent).getBody();
    }
}
