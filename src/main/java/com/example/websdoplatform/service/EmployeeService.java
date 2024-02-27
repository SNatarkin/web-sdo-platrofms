package com.example.websdoplatform.service;

import com.example.websdoplatform.dto.EmployeeDto.EmployeeSaveRequestDto;
import com.example.websdoplatform.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> getEmployeeById(Long employeeId);

    Page<Employee> getAllEmployee(Pageable pageable);

    Employee saveEmployee(EmployeeSaveRequestDto employeeSaveRequestDto);

    void deleteEmployeeById(Long employeeId);

    void deleteAllEmployees();

    void getCsvFIle(OutputStream outputStream) throws IOException;
}
