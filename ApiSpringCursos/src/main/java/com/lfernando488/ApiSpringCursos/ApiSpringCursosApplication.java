package com.lfernando488.ApiSpringCursos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lfernando488.ApiSpringCursos.Models.Course;
import com.lfernando488.ApiSpringCursos.Repositories.CourseRepository;

@SpringBootApplication
public class ApiSpringCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringCursosApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args ->{
			courseRepository.deleteAll();

			Course c1 = new Course();
			c1.setName("Angular");
			c1.setCategory("Front-end");
			
			Course c2 = new Course();
			c2.setName("Spring");
			c2.setCategory("Back-end");
			
			courseRepository.saveAll(List.of(c1,c2));
		};
	}
	
}
