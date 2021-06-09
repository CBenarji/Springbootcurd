package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentService;

import antlr.collections.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo; // HAS-Relationship

	@Override
	public Integer saveStudent(Student st) {
		return repo.save(st).getId();

	}

	@Override
	public Optional<Student> getOneStudent(Integer id) {
		return repo.findById(id);
	}

	@Override
	public java.util.List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public void deletStudent(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public boolean isExist(Integer id) {
		return repo.existsById(id);

	}

}
