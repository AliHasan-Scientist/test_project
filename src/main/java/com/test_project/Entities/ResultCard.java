package com.test_project.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "result_card")
public class ResultCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_cardID", unique = true, nullable = false)
    private Long resultResultId;
    @Column(name = "uni_name")
    private String universityName;
    @Column(name = "stud_image")
    private String image;
    @Column(name = "announce_date")
    private Date announcedDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_ID")
    @JsonBackReference
    private Student student;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "resultCard_ID")
    @JsonBackReference
    private Result result;

    //def constructor
    public ResultCard() {
    }
}
