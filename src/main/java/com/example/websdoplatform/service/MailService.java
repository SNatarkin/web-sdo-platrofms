package com.example.websdoplatform.service;

import com.example.websdoplatform.dto.StatementType;

public interface MailService {



    void sendMailWithAttachment(StatementType type);
}
