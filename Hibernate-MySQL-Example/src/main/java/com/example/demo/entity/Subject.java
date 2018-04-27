package com.example.demo.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "subject")
	private Set<Student> student = new HashSet<>();

	public Subject() {
		
	}
	
	public Subject(int id, String name, Set<Student> student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public Subject( String name) {
		 this.name = name; 
		}

		public Subject(String name, Set<Student> student){
	        this.name = name;
	        this.student = student;
	    }
	
}
