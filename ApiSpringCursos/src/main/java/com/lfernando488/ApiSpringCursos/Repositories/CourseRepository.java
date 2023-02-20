package com.lfernando488.ApiSpringCursos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lfernando488.ApiSpringCursos.Models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
