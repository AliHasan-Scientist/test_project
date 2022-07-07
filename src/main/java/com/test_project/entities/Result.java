package com.test_project.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stud_result")
public class Result {
    @Id
    @SequenceGenerator(name = "result_sequence", sequenceName = "result_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_sequence")
    @Column(name = "result_ID", nullable = false, unique = true )
    //primary key of stud_result
    private Long resultId;
    @Column(name = "stud_RN", nullable = false, unique = true)
    private Long studentRollNum;
    @Column(name = "semester_details", nullable = false)
    private String semester;
    @Column(name = "reg_num", nullable = false, unique = true)
    private Long registrationNum;
    @Column(name = "course_code", nullable = false, unique = true)
    private Long courseCode;
    @Column(name = "course_tilte", nullable = false)
    private String courseTitle;
    @Column(name = "total_marks", nullable = false)
    private Integer totalMarks;
    @Column(name = "exam_marks", nullable = false)
    private Integer examMarks;
    @Column(name = "obtain_marks", nullable = false)
    private Integer obtainMarks;
    @Column(name = "stud_grade", nullable = false)
    private String grade;
    @Column(name = "result_status", nullable = false)
    private boolean status;
    //Result can <Have> One Student
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stud_id")
    private Student student;

    // Result have many Result Card
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "result")
    @JsonManagedReference
    private List<ResultCard> resultCard;

    //default constructor
    public Result() {
    }
}
