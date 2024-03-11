package com.example.websdoplatform.repository;

import com.example.websdoplatform.model.Marks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends PagingAndSortingRepository<Marks, Long> {

    Page<Marks> findMarksByParticipantStudyingName(Pageable pageable, String participantStudyingId);
}