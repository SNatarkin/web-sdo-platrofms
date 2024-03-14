package com.example.websdoplatform.controller;

import com.example.websdoplatform.model.Marks;
import com.example.websdoplatform.service.MarksBookGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MarksBookController {

    private final MarksBookGateway marksBookGateway;

    @GetMapping("/marks")
    public String getAllMarks(@PageableDefault(size = 10) Pageable pageable,
                              Model model,
                              @RequestParam(required = false) String studentName,
                              @RequestParam(required = false) String ratingFilter,
                              @RequestParam(required = false) String subjectFilter) {
        Page<Marks> marksPage;
        if (studentName != null) {
            marksPage = marksBookGateway.getMarksByStudentName(pageable, studentName);
        }
        marksPage = marksBookGateway.getAllMarks(pageable);

        String sqlQuery = "SELECT * FROM marks";

        if (studentName != null || ratingFilter != null || subjectFilter != null) {
            sqlQuery += " WHERE";

            List<String> conditions = new ArrayList<>();

            if (studentName != null) {
                conditions.add(" student_name = '" + studentName + "'");
            }

            if (ratingFilter != null) {
                conditions.add(" rating = '" + ratingFilter + "'");
            }

            if (subjectFilter != null) {
                conditions.add(" subject = '" + subjectFilter + "'");
            }

            sqlQuery += String.join(" AND ", conditions);
        }
        sqlQuery += " LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

        model.addAttribute("page", marksPage);
        model.addAttribute("select", sqlQuery);

        return "marksTable";
    }

    @GetMapping("/marks/{studentName}")
    public String getMarksByStudentName(@PageableDefault(size = 10) Pageable pageable,
                                        Model model, @RequestParam(required = false) String studentName) {
        model.addAttribute("page", marksBookGateway.getMarksByStudentName(pageable, studentName));
        return "marksTable";
    }


    @PostMapping("/marks/save")
    public String saveStudent() {
        marksBookGateway.saveMarks();
        return "redirect:/marks";
    }
}
