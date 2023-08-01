package com.tw.AnthonyFu.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employee_id;
	@Column(name = "employee_name")
	private String employee_name;
	@Column(name = "employee_email")
	private String employee_email;
	// 1 male, 0 female
	@Column(name = "employee_gender")
	private Integer employee_gender;
	@Column(name = "employee_department")
	private String employee_department;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "employee_birth")
	private Date employee_birth;
	@Column(name = "employee_shows")
	private Integer employee_shows;
	
}
