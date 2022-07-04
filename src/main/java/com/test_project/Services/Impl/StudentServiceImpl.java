package com.test_project.Services.Impl;

import com.test_project.Dto.StudentDto;
import com.test_project.Entities.Student;
import com.test_project.Exceptions.ResourceNotFoundException;
import com.test_project.Repository.StudentRepository;
import com.test_project.Services.StudentService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @NonNull
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public StudentDto addAStudent(StudentDto studentDto) {
        Student student = dtoToStudent(studentDto);
        Student savedStudent = this.studentRepository.save(student);
        return this.studentToDto(savedStudent);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = this.studentRepository.findAll();
        return students.stream().map(this::studentToDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentWithId(Long studentId) {
        Student student = studentRepository.findById((studentId)).orElseThrow(null);
        return studentToDto(student);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Long studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", studentId));
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setGender(studentDto.getGender());
        student.setAge(studentDto.getAge());
        student.setStudentAddress(studentDto.getStudentAddress());
        student.setEmail(studentDto.getEmail());
        student.setStudentPassword(studentDto.getStudentPassword());
        Student updatedStudent = studentRepository.save(student);
        return this.studentToDto(student);
    }

    @Override
    public StudentDto deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(null);
        studentRepository.delete(student);
        return null;
    }

    @Override
    public List<Student> findStudentByFirstName(String studentName) {
        return studentRepository.findByFirstNameOrLastNameIgnoreCase(studentName, studentName);
    }

    //Model Mapper
    private Student dtoToStudent(StudentDto studentDto) {
        return this.modelMapper.map(studentDto, Student.class);
    }

    public StudentDto studentToDto(Student student) {
        return this.modelMapper.map(student, StudentDto.class);
    }
}
