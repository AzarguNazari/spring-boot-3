package com.kn.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class MyApp {

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}


	@Bean
	ApplicationRunner appStarted(ConfigProperties configProperties) {
		return args -> {
			System.out.println(configProperties);
//			var john = new Person(1L, "John");
//			personRepository.save(john);
//			personRepository.findAll().forEach(System.out::println);
		};
	}

}

//@Entity
//record Person(@Id Long id, String name){
//	Person(){
//		this(0L, null);
//	}
//}
//
//interface PersonRepository extends JpaRepository<Person, Long> {}


