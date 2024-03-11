package com.example.websdoplatform.service.impl;

import com.example.websdoplatform.model.Marks;
import com.example.websdoplatform.model.ParticipantsStudying;
import com.example.websdoplatform.model.Subjects;
import com.example.websdoplatform.repository.MarksRepository;
import com.example.websdoplatform.service.MarksBookGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarksBookGatewayImpl implements MarksBookGateway {


    private final MarksRepository marksRepository;

    private final String SHABLON = "SELECT % asdasd sadasda";

    @Override
    public Page<Marks> getMarksByStudentName(Pageable pageable, String studentName) {
        return marksRepository.findMarksByParticipantStudyingName(pageable, studentName);
    }

    @Override
    public Marks saveMarks() {
        Marks marks = new Marks();
        Subjects subject = new Subjects();
        subject.setComment("123");
        subject.setSubjectName("total");
        ParticipantsStudying participantStudying = new ParticipantsStudying();
        participantStudying.setComment("333");
        participantStudying.setRolesParticipantsId(3L);
        participantStudying.setName("natar");

        marks.setComment("123");
        marks.setMark("5");
        marks.setSubject(subject);
        marks.setComment("123");
        marks.setParticipantStudying(participantStudying);
        return marks;
    }

    @Override
    public Page<Marks> getAllMarks(Pageable pageable) {
        return marksRepository.findAll(pageable);
    }
}
