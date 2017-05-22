package com.epam;

import com.epam.cinema.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CinemaApplication {
	@Autowired
	AuditoriumRepository repository;

	@PostConstruct
	public void test(){
		repository.getAllAuditoriums();
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);

	}
}
