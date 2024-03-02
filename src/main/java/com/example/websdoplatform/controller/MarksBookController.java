package com.example.websdoplatform.controller;

import com.example.websdoplatform.service.MarksBookGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"/grade-book", "/grade-book"}, produces = APPLICATION_JSON_VALUE)
public class MarksBookController {

    private final MarksBookGateway marksBookGateway;

    @GetMapping("/student/{studentName}")
    public String getGradesByStudentName(@PageableDefault(size = 10) Pageable pageable,
                                         Model model, @PathVariable String studentName) {
        model.addAttribute("page", marksBookGateway.getGradesByStudentName(pageable, studentName));
        return "employeesTable";
    }
}
