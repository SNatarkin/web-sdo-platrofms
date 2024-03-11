package com.example.websdoplatform.service;

import com.example.websdoplatform.model.Marks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarksBookGateway {

    Page<Marks> getMarksByStudentName(Pageable pageable, String studentName);

    Marks saveMarks();

    Page<Marks> getAllMarks(Pageable pageable);
}
