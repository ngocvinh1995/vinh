package com.btit95.sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.btit95.sample.entities.Course;
import com.btit95.sample.repositories.CourseRepository;

@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String courses(ModelMap model) {
		model.addAttribute("courses", (List<Course>) courseRepository.findAll());
		return "courses";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String addCourse(@PathVariable("id") int id, ModelMap model) {
		courseRepository.delete(id);
		return "redirect:/courses";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addCourse(ModelMap model) {
		model.addAttribute("course", new Course());
		return "course";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("course") Course course, ModelMap model) {
		Course c = courseRepository.save(course);
		if(null != c) {
			model.addAttribute("message", "A course added");
			model.addAttribute("course", c);
		} else {
			model.addAttribute("message", "Please input again");
			model.addAttribute("course", course);
		}
		return "course";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editCourse(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("course", courseRepository.findOne(id));
		return "course";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute("course") Course course, ModelMap model) {
		Course cs = courseRepository.save(course);
		if(null != cs) {
			model.addAttribute("message", "Update success");
			model.addAttribute("course", courseRepository.findOne(cs.getId()));
		} else {
			model.addAttribute("message", "Update failure");
			model.addAttribute("course", course);
		}
		return "course";
	}
}
