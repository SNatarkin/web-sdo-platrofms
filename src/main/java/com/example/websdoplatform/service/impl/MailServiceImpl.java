package com.example.websdoplatform.service.impl;

import com.example.websdoplatform.config.EmailProperties;
import com.example.websdoplatform.dto.StatementType;
import com.example.websdoplatform.service.EmployeeService;
import com.example.websdoplatform.service.MailService;
import com.example.websdoplatform.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;
    private final EmailProperties emailProperties;
    private final EmployeeService employeeService;
    private final StudentService studentService;

    @Override
    public void sendMailWithAttachment(StatementType type) {
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            if(StatementType.EMPLOYEE.equals(type)) {
                employeeService.getCsvFIle(bout);
            }
            else{
                studentService.getCsvFIle(bout);
            }
            sendToEmail(emailProperties.getEmailTo(), bout.toByteArray());
        } catch (IOException | MessagingException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void sendToEmail(String emailTo, byte[] buffer) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setTo(emailTo);
        helper.setFrom(emailProperties.getUsername());
        helper.setSubject("Выгрузка CSV");
        helper.addAttachment(LocalDate.now().toString()+".csv",new ByteArrayResource(buffer),
                "application/"+"csv");
        helper.setText("", true);

        mailSender.send(mimeMessage);
    }
}

