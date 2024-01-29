package com.example.graal21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Map;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@SpringBootApplication

public class Graal21Application {

	public static void main(String[] args) {
		SpringApplication.run(Graal21Application.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routes(CustomerRepository customerRepository) {
		return route(GET("/customer"),
				request -> ServerResponse.ok().body(customerRepository.findAll()))
				.and(route(GET("/machin"), request ->
						ServerResponse.ok().render("customers", Map.of("customers", customerRepository.findAll()))));
	}


}

@Controller
class CustomerController {
	CustomerRepository customerRepository;

	CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping("/customers")
	public String customers(ModelMap map) {
		map.put("customers", customerRepository.findAll());
		return "customers";

	}
}
interface CustomerRepository extends ListCrudRepository<Customer, Integer> {

}

record Customer(@Id Integer id, String name) {
}
