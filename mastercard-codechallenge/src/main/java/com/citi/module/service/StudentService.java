package com.citi.module.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.citi.module.domain.Student;

@Service
public class StudentService {
	@Cacheable("student")
	public Student getStudentByID(String id) {
		try {
			System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Student(id,"Sajal" ,"V");
	}
	
	@CacheEvict("student")
	public Student deleteStudentById(String id) {
		return null;		
	}
	
	@CachePut(value="student")
	public Student updateStudentById(String id) {
		System.out.println("Executing Update value ... ");
		
		Student student = new Student();
		
		student.setName("SajalUpdated");
		
		return student;
	}
}
