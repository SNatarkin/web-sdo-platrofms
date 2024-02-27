package com.example.websdoplatform.dto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeSaveRequestDto {

    private String name;
    private String position;
    private String cathedra;
    private String date;
    private String number;
    private String disciplines;
    private String mail;
}
