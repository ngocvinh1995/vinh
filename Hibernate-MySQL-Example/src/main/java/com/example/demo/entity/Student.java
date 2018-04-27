package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		 private int id;
		
		@Column(name = "name")
		private String name;
		
		@ManyToMany(cascade = { CascadeType.ALL })	          
	    @JoinTable(name = "student_subject",
	            joinColumns = { @JoinColumn(name = "student_id") },
	            inverseJoinColumns = { @JoinColumn(name = "subject_id") })
	    private Set<Subject> subject = new HashSet<>();

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

		public Set<Subject> getSubject() {
			return subject;
		}

		public void setSubject(Set<Subject> subject) {
			this.subject = subject;
		}

		public Student(int id, String name, Set<Subject> subject) {
			super();
			this.id = id;
			this.name = name;
			this.subject = subject;
		}

		public Student( String name) {
			 this.name = name; 
			}

			public Student(String name, Set<Subject> subject){
		        this.name = name;
		        this.subject= subject;
		    }
		
		
}
