package com.lfernando488.ApiSpringCursos.Controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lfernando488.ApiSpringCursos.Models.Course;
import com.lfernando488.ApiSpringCursos.Repositories.CourseRepository;

//import lombok.AllArgsConstructor;

@Validated //Ativa as validações na entrada dos métodos do controller
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> findById(@PathVariable("id") @NotNull @Positive Long id){
		return courseRepository.findById(id)
				.map(res -> ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}
	
  /*@PostMapping
	public ResponseEntity<Course> create(@RequestBody Course course){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
	}
  */
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course create(@RequestBody @Valid Course course){
		return courseRepository.save(course);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> update(@PathVariable("id") @NotNull @Positive Long id, @RequestBody @Valid Course course) {
		return courseRepository.findById(id)
				.map(resFound -> {
					resFound.setName(course.getName()); 
					resFound.setCategory(course.getCategory());
					Course updated = courseRepository.save(resFound);
					return ResponseEntity.ok().body(updated);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") @NotNull @Positive Long id){
		return courseRepository.findById(id)
				.map(resFound -> {
					courseRepository.deleteById(id);
					return ResponseEntity.noContent().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
