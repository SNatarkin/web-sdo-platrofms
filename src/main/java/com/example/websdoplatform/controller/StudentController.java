package com.example.websdoplatform.controller;


import com.example.websdoplatform.dto.StudentDto.StudentSaveRequestDto;
import com.example.websdoplatform.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final MailService mailService;

    @GetMapping("/student")
    public String getAllStudent(@PageableDefault(size = 10) Pageable pageable, Model model) {
        model.addAttribute("page", studentService.getAllStudent(pageable));
        return "studentsTable";
    }

    @PostMapping("/student/save")
    public String saveStudent(@ModelAttribute("student") StudentSaveRequestDto studentSaveRequestDto) {
        studentService.saveStudent(studentSaveRequestDto);
        return "redirect:/student";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }

}
