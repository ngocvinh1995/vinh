package com.btit95.sample.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	private String address;
	@Column(name = "head_teacher_id", insertable = false, updatable = false)
	private int headTeacherId;
	@ManyToOne
	@JoinColumn(name = "head_teacher_id", nullable = false)
	private HeadTeacher headTeacher;
	@ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "student_course", joinColumns = {
	@JoinColumn(name = "student_id", referencedColumnName = "id",  updatable = true) }, inverseJoinColumns = {
	@JoinColumn(name = "course_id", referencedColumnName = "id", nullable = true, updatable = false) })
	private Set<Course> courses;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private StudentCard studentCard;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public HeadTeacher getHeadTeacher() {
		return headTeacher;
	}

	public void setHeadTeacher(HeadTeacher headTeacher) {
		this.headTeacher = headTeacher;
	}

	 public Set<Course> getCourses() {
	 return courses;
	 }
	
	 public void setCourses(Set<Course> courses) {
	 this.courses = courses;
	 }

	public StudentCard getStudentCard() {
		return studentCard;
	}

	public void setStudentCard(StudentCard studentCard) {
		studentCard.setStudent(this);
		this.studentCard = studentCard;
	}

	public int getHeadTeacherId() {
		return headTeacherId;
	}

	public void setHeadTeacherId(int headTeacherId) {
		this.headTeacherId = headTeacherId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", headTeacherId="
				+ headTeacherId + ", studentCard=" + studentCard + "]";
	}

}
