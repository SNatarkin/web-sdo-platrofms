package com.example.websdoplatform.repository;

import com.example.websdoplatform.model.Marks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MarksRepository extends PagingAndSortingRepository<Marks, Long> {

    @Query("SELECT ASDASDASDSD")
    Page<Marks> findByStudentName(Pageable pageable, String studentName);
}