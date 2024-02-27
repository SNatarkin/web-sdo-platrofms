package com.example.websdoplatform.dto.StudentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveRequestDto {


    private String name;
    private String number;
    private String birthDate;
    private String faculty;
    private String mail;
}
