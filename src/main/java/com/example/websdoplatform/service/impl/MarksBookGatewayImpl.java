package com.example.websdoplatform.service.impl;

import com.example.websdoplatform.model.Marks;
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

    @Override
    public Page<Marks> getGradesByStudentName(Pageable pageable, String studentName) {
        return marksRepository.findByStudentName(pageable, studentName);
    }
}
