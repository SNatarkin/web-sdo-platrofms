package com.example.websdoplatform.service.impl;

import com.example.websdoplatform.dto.EmployeeDto.EmployeeSaveRequestDto;
import com.example.websdoplatform.model.Employee;
import com.example.websdoplatform.repository.EmployeeRepository;
import com.example.websdoplatform.service.EmployeeService;
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

@Service("defaultEmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
    private final static String[] CSV_HEADERS = {"Employee Id", "Name",
            "Position", "Cathedra", "Date", "Disciplines", "Number", "Mail"};
    private final static String[] FIELDS = {"id", "name", "position", "cathedra", "date", "disciplines", "number", "mail"};

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee saveEmployee(EmployeeSaveRequestDto employeeSaveRequestDto) {
        Employee employee = new Employee();
        employee.setCathedra(employeeSaveRequestDto.getCathedra());
        employee.setDate(employeeSaveRequestDto.getDate());
        employee.setMail(employeeSaveRequestDto.getMail());
        employee.setNumber(employeeSaveRequestDto.getNumber());
        employee.setPosition(employeeSaveRequestDto.getPosition());
        employee.setName(employeeSaveRequestDto.getName());
        employee.setDisciplines(employeeSaveRequestDto.getDisciplines());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    @Override
    public void getCsvFIle(OutputStream outputStream) {
        try {
            BufferedWriter buff = new BufferedWriter(new OutputStreamWriter(outputStream, "Windows-1251"));
            List<Employee> listEmployee = employeeRepository.findAll();
            ICsvBeanWriter csvWriter = new CsvBeanWriter(buff, CsvPreference.EXCEL_PREFERENCE);
            csvWriter.writeHeader(CSV_HEADERS);
            for (Employee employee : listEmployee) {
                csvWriter.write(employee, FIELDS);
            }
            csvWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
