package com.btit95.sample.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "studentcard")
public class StudentCard implements Serializable {
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "student"))
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name = "student_id", nullable = false)
	private int studentId;
	@Column(name = "card_number")
	private int cardNumber;
	@OneToOne(mappedBy = "studentCard")
	private Student student;

	public StudentCard() {
		// TODO Auto-generated constructor stub
	}

	public StudentCard(int studentId, int cardNumber) {
		super();
		this.studentId = studentId;
		this.cardNumber = cardNumber;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "StudentCard [studentId=" + studentId + ", cardNumber=" + cardNumber + ", Student=" + student.getName()
				+ "]";
	}

}
