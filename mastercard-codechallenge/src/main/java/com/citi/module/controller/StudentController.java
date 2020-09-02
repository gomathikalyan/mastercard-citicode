package com.citi.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.module.domain.Student;
import com.citi.module.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable String id) {
		System.out.println("Searching by ID  : " + id);
		return studentService.getStudentByID(id);
	}
	
	@DeleteMapping("/student/{id}")
	public Student deleteStudentById(@PathVariable String id) {
		System.out.println("Deleting Student details by ID  : " + id);
		return studentService.deleteStudentById(id);
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudentById(@PathVariable String id) {
		System.out.println("Updating Student details by ID  : " + id);
		return studentService.updateStudentById(id);
	}
}
