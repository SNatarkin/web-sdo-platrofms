package com.example.websdoplatform.service.impl;

import com.example.websdoplatform.dto.StudentDto.StudentSaveRequestDto;
import com.example.websdoplatform.model.Student;
import com.example.websdoplatform.repository.StudentRepository;
import com.example.websdoplatform.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Optional;

@Service("defaultStudentService")
public class StudentServiceImpl implements StudentService {

    private final static String[] CSV_HEADERS = {"Student Id", "Name",
            "Number", "BirthDate", "Faculty", "Mail"};
    private final static String[] FIELDS = {"id", "name",
            "number", "birthDate", "faculty", "mail"};

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Page<Student> getAllStudent(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student saveStudent(StudentSaveRequestDto studentSaveRequestDto) {
        Student student = new Student();
        student.setBirthDate(studentSaveRequestDto.getBirthDate());
        student.setFaculty(studentSaveRequestDto.getFaculty());
        student.setMail(studentSaveRequestDto.getMail());
        student.setNumber(studentSaveRequestDto.getNumber());
        student.setName(studentSaveRequestDto.getName());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public void getCsvFIle(OutputStream outputStream) throws IOException {
        try {
            BufferedWriter buff = new BufferedWriter(new OutputStreamWriter(outputStream, "Windows-1251"));
            List<Student> listStudent = studentRepository.findAll();
            ICsvBeanWriter csvWriter = new CsvBeanWriter(buff, CsvPreference.EXCEL_PREFERENCE);
            csvWriter.writeHeader(CSV_HEADERS);
            for (Student student : listStudent) {
                csvWriter.write(student, FIELDS);
            }
            csvWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
