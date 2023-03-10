package com.lfernando488.ApiSpringCursos.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@SQLDelete(sql = "UPDATE COURSES SET STATUS = 'Inactive' WHERE ID = ?") //Executa ao chamar o Delete para apeans desativar o curso
@Where(clause = "STATUS = 'Active'") // Retorna apenas os cursos ativos no where
@Data
@Entity
@Table(name = "COURSES")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	@JsonProperty("_id")
	private Long id;
	
	@NotNull
	@NotBlank
	@Length(min = 5, max = 100)
	@Column(name = "NAME", length = 100, nullable = false)
	private String name;
	
	@NotNull
	@Length(max = 10)
	@Pattern(regexp = "Back-end|Front-end")
	@Column(name = "CATEGORY", length = 10, nullable = false)
	private String category;
	
	@NotNull
	@Length(max = 10)
	@Pattern(regexp = "Active|Inactive")
	@Column(name = "STATUS", length = 10, nullable = false)
	private String status;
	
}
