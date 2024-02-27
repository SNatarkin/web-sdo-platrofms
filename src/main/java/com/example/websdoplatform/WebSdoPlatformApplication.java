package com.example.websdoplatform;

import com.example.websdoplatform.config.EmailConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(EmailConfiguration.class)
public class WebSdoPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSdoPlatformApplication.class, args);
    }

}
