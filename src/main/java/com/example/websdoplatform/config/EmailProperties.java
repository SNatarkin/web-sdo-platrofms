package com.example.websdoplatform.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("com.websdoplatform")
@Data
public class EmailProperties {
    private String emailTo;
    private String host;
    private int port;
    private String username;
    private String password;
}
