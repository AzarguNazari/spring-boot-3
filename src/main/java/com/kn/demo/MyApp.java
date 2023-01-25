package com.kn.demo;

import com.kn.demo.webclient.PersonClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class MyApp {

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}

	@Bean
	PersonClient client(WebClient.Builder builder) {
		return HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(builder.baseUrl("http://localhost:8080/").build()))
				.build()
				.createClient(PersonClient.class);
	}

	@Bean
	CommandLineRunner run(PersonClient personClient){
		return arg -> {
			personClient.all().subscribe(System.out::println);
		};
	}
}


