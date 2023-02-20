package com.lfernando488.ApiSpringCursos.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lfernando488.ApiSpringCursos.Models.Course;
import com.lfernando488.ApiSpringCursos.Repositories.CourseRepository;

//import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
//@AllArgsConstructor
public class CourseController {


	private CourseRepository courseRepository;
	
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@GetMapping
	public List<Course> list(){
		return courseRepository.findAll();
	}
	
  /*@PostMapping
	public ResponseEntity<Course> create(@RequestBody Course course){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
	}
  */
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course create(@RequestBody Course course){
		return courseRepository.save(course);
	}
	
}