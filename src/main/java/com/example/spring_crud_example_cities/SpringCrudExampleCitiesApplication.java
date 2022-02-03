package com.example.spring_crud_example_cities;

import com.example.spring_crud_example_cities.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class SpringCrudExampleCitiesApplication implements ApplicationRunner {

	private final CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudExampleCitiesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		cityRepository.findAll().forEach(n-> System.out.println(n.getName()));
	}
}
