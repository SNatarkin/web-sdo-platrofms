package com.example.websdoplatform.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marks")
@Getter
@Setter
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "participant_studying_id")
    private Long participantStudyingId;
    @Column(name = "subject_id")
    private Long subjectId;
    private String mark;
    private Date date;
    private String comment;
}