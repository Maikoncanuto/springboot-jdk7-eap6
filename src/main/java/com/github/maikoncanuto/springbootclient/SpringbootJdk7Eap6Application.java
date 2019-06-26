package com.github.maikoncanuto.springbootclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringbootJdk7Eap6Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJdk7Eap6Application.class, args);
    }

}
