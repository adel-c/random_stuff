package com.ace.thymleafdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@SpringBootApplication
public class ThymleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymleafDemoApplication.class, args);
    }


    @Repository
    public interface UserRepository extends CrudRepository<User, Integer> {}

    @Entity
    @Table(name = "USERS")
    record User(@Id Integer id, String name, String salt, String password, String email, String role) implements Serializable {}
}
