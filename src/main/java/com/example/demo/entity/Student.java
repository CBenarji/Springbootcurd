package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_TABLE")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "St_Id")
	private Integer id;
	@Column(name = "St_Name")
	private String name;
	@Column(name = "St_Couers")
	private String couers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCouers() {
		return couers;
	}

	public void setCouers(String couers) {
		this.couers = couers;
	}

	public Student(Integer id, String name, String couers) {
		super();
		this.id = id;
		this.name = name;
		this.couers = couers;
	}

	public Student() {
	}

}
