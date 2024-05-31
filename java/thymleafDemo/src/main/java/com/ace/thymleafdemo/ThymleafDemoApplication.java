package com.ace.thymleafdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

@SpringBootApplication
public class ThymleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymleafDemoApplication.class, args);
    }



    @Entity
    @Table(name = "USERS")
    record User(Integer id, String name,String salt,String password,String email,String role) implements Serializable {}
}
