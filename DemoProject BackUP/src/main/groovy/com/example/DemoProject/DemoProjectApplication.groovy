package com.example.DemoProject

import org.modelmapper.ModelMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoProjectApplication {

	static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication, args)
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
