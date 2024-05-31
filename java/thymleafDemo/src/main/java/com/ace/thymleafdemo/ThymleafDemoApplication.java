package com.ace.thymleafdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

@SpringBootApplication
public class ThymleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymleafDemoApplication.class, args);
    }

    @Controller
    @ResponseBody
    public static class UserController{
        private final UserRepository userRepository;

        public UserController(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @GetMapping("/users/")
        public List<User> users(){
            return userRepository.findAll();
        }
    }

    @Repository
    public interface UserRepository extends ListCrudRepository<User, Integer> {}

    @Entity
    @Table(name = "USERS")
    record User(@Id Integer id, String name, String salt, String password, String email, String role)  {}
}
