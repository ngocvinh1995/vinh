package com.ifi.demo.controller;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ifi.demo.entities.Student;
import com.ifi.demo.repo.StudentRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/students")
public class MainController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping()
    public Collection<Student> student() {
        return studentRepository.findAll().stream().collect(Collectors.toList());
	 }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("id") Long id) {
		return studentRepository.findAll().stream().filter(student -> student.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		Student modifiedStudent = studentRepository.findAll().stream().filter(stu -> stu.getId() == student.getId()).findFirst().orElse(null);
		modifiedStudent.setName(student.getName());
		modifiedStudent.setAge(student.getAge()); 
		modifiedStudent.setAddress(student.getAddress());
		studentRepository.save(modifiedStudent);
		return modifiedStudent;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteStudent(@PathVariable Long id) {
		Student deleteStudent = studentRepository.findAll().stream().filter(student -> student.getId() == id).findFirst().orElse(null);
		if (deleteStudent != null) {
			studentRepository.deleteById(id);
			return true;
		} else  {
			return false;
		}
	}

}
