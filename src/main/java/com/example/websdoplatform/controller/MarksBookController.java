package com.example.websdoplatform.controller;

import com.example.websdoplatform.service.MarksBookGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequiredArgsConstructor
public class MarksBookController {

    private final MarksBookGateway marksBookGateway;

    @GetMapping("/marks")
    public String getAllMarks(@PageableDefault(size = 10) Pageable pageable,
                              Model model) {
        model.addAttribute("page", marksBookGateway.getAllMarks(pageable));
        return "marksTable";
    }

    @GetMapping("/marks/{studentName}")
    public String getMarksByStudentName(@PageableDefault(size = 10) Pageable pageable,
                                        Model model, @PathVariable String studentName) {
        model.addAttribute("page", marksBookGateway.getMarksByStudentName(pageable, studentName));
        return "marksTable";
    }


    @PostMapping("/marks/save")
    public String saveStudent() {
        marksBookGateway.saveMarks();
        return "redirect:/marks";
    }
}
