package com.ace.thymleafdemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class ThymleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymleafDemoApplication.class, args);
    }


}
class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }
}
@AllArgsConstructor
@RestController
class UserController {
    private final UserRepository userRepository;


    @GetMapping("/users")
    public List<User> users() {
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public User user(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow();
    }
}

@Repository
interface UserRepository extends ListCrudRepository<User, Integer> {
}

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@Getter
class User {
    @Id
    private Integer id;
    private String name;
    @JsonIgnore
    private String salt;
    @JsonIgnore
    private String password;
    private String email;
    private String role;
}
