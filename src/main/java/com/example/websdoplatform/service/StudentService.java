package com.example.websdoplatform.service;

import com.example.websdoplatform.dto.StudentDto.StudentSaveRequestDto;
import com.example.websdoplatform.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

public interface StudentService {

    Optional<Student> getStudentById(Long studentId);

    Page<Student> getAllStudent(Pageable pageable);

    Student saveStudent(StudentSaveRequestDto studentSaveRequestDto);

    void deleteStudentById(Long studentId);

    void deleteAllStudents();

    void getCsvFIle(OutputStream outputStream) throws IOException;

}
