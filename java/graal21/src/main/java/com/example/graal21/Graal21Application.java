package com.example.graal21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

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
				request -> ServerResponse.ok().body(customerRepository.findAll()));
	}


}
@Repository
interface CustomerRepository extends ListCrudRepository<Customer, Integer> {

}

record Customer(@Id Integer id, String name) {
}
