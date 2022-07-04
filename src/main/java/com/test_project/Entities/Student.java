package com.test_project.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "stud_ID", nullable = false, unique = true)
    //primary key of student_table
    private Long studentId;
    @Column(name = "stud_fName", nullable = false, length = 65)
    private String firstName;
    @Column(name = "stud_lName", nullable = false, length = 65)
    private String lastName;
    @Column(name = "stud_gender")
    private String gender;
    @Column(name = "stud_age")
    private Integer age;
    @Column(name = "stud_address")
    private String studentAddress;
    @Column(name = "stud_email", nullable = false, unique = true)
    private String email;
    @Column(name = "stud_pass", nullable = false)

    private String studentPassword;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Result> results = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "student")
    @JsonManagedReference
    private List<ResultCard> resultCard;

    // default constructor
    public Student() {
    }
}
