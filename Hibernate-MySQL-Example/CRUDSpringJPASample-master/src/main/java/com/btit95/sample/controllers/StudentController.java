package com.btit95.sample.controllers;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.btit95.sample.entities.Course;
import com.btit95.sample.entities.HeadTeacher;
import com.btit95.sample.entities.Student;
import com.btit95.sample.repositories.CourseRepository;
import com.btit95.sample.repositories.HeadTeacherRepository;
import com.btit95.sample.repositories.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private HeadTeacherRepository headTeacherRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String students(ModelMap model) {
		model.addAttribute("students", (List<Student>) studentRepository.findAll());
		return "students";
	}
	
	private void initFormData(ModelMap model) {
		model.addAttribute("courses", (List<Course>)courseRepository.findAll());
		model.addAttribute("teachers", (List<HeadTeacher>) headTeacherRepository.findAll());
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id) {
		studentRepository.delete(id);
		return "redirect:/students";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addStudent(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		initFormData(model);
		return "student";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, ModelMap model) {
		Student std = studentRepository.save(student);
		if(null != std) {
			model.addAttribute("message", "A student added");
			model.addAttribute("student", std);
		} else {
			model.addAttribute("message", "Please input again");
			model.addAttribute("student", student);
		}
		initFormData(model);
		return "student";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("student", studentRepository.findOne(id));
		initFormData(model);
		return "student";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(HeadTeacher.class, "headTeacher", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(headTeacherRepository.findOne(Integer.parseInt(text)));
			}
		});
		binder.registerCustomEditor(Course.class, "courses", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(courseRepository.findOne(Integer.parseInt(text)));
			}
		});
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute("student") Student student, ModelMap model) {
		Student std = studentRepository.save(student);
		if(null != std) {
			model.addAttribute("message", "Update success");
			model.addAttribute("student", studentRepository.findOne(std.getId()));
		} else {
			model.addAttribute("message", "Update failure");
			model.addAttribute("student", student);
		}
		initFormData(model);
		return "student";
	}
}
