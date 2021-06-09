package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Student;

import antlr.collections.List;

public interface StudentService {
	
	public Integer saveStudent(Student st);
	
	public Optional<Student> getOneStudent(Integer id);
	
	public  java.util.List<Student> getAllStudent();
	public boolean isExist(Integer id);
	
	public void deletStudent(Integer id);
	

}
