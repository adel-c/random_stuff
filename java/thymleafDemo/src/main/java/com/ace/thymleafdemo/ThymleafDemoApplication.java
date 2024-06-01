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
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Configuration
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
@RequestMapping("api/")
class CustomerJsonController {
    private final CustomerRepository userRepository;


    @GetMapping("/customer")
    public List<Customer> users() {
        return userRepository.findAll();
    }
    @GetMapping("/customer/{id}")
    public Customer user(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow();
    }
}

@AllArgsConstructor
@Controller
class CustomerController {
    private final CustomerRepository userRepository;


    @GetMapping("/customer")
    public String users(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

}

@Repository
interface CustomerRepository extends ListCrudRepository<Customer, Integer> {
}

@Entity
@Table(name = "CUSTOMER")
@NoArgsConstructor
@Getter
class Customer {
    @Id
    private Integer id;
    private String name;
    private String email;
}
