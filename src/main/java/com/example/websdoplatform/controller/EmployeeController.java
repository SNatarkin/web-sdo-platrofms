package com.example.websdoplatform.controller;

import com.example.websdoplatform.dto.EmployeeDto.EmployeeSaveRequestDto;
import com.example.websdoplatform.service.EmployeeService;
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
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/employee")
    public String getAllEmployee(@PageableDefault(size = 10) Pageable pageable,
                                 Model model) {
        model.addAttribute("page", employeeService.getAllEmployee(pageable));
        return "employeesTable";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeSaveRequestDto employeeSaveRequestDto) {
        employeeService.saveEmployee(employeeSaveRequestDto);
        return "redirect:/employee";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }
}
