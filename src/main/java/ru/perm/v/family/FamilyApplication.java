package ru.perm.v.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc // Need for OpenApiDoc
public class FamilyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FamilyApplication.class, args);
    }

}
