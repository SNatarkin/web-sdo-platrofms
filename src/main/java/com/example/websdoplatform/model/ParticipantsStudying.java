package com.example.websdoplatform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "participants_studying")
@Getter
@Setter
public class ParticipantsStudying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "roles_participants_id")
    private Long rolesParticipantsId;
    private String name;
    private String comment;
}
