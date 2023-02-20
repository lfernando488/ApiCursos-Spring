package com.lfernando488.ApiSpringCursos.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "COURSES")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	@JsonProperty("_id")
	private Long id;
	
	@Column(name = "NAME", length = 200, nullable = false)
	private String name;
	
	@Column(name = "CATEGORY", length = 20, nullable = false)
	private String category;
	
}
