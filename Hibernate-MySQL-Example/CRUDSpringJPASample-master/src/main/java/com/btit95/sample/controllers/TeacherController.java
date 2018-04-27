package com.btit95.sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.btit95.sample.entities.HeadTeacher;
import com.btit95.sample.repositories.HeadTeacherRepository;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
	@Autowired
	private HeadTeacherRepository headTeacherRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String teachers(ModelMap model) {
		model.addAttribute("teachers", (List<HeadTeacher>) headTeacherRepository.findAll());
		return "teachers";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteTeacher(@PathVariable("id") int id) {
		headTeacherRepository.delete(id);
		return "redirect:/teachers";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addTeacher(ModelMap model) {
		model.addAttribute("teacher", new HeadTeacher());
		return "teacher";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addTeacher(@ModelAttribute("teacher") HeadTeacher headTeacher, ModelMap model) {
		HeadTeacher teacher = headTeacherRepository.save(headTeacher);
		if(null != teacher) {
			model.addAttribute("message", "A teacher added");
			model.addAttribute("teacher", teacher);
		} else{
			model.addAttribute("message", "Please input again");
			model.addAttribute("teacher", headTeacher);
		}
		
		return "teacher";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String updateTeacher(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("teacher", headTeacherRepository.findOne(id));
		return "teacher";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String updateTeacher(@ModelAttribute("teacher") HeadTeacher headTeacher, ModelMap model) {
		HeadTeacher teacher = headTeacherRepository.save(headTeacher);
		if(null != teacher) {
			model.addAttribute("message", "Update success");
			model.addAttribute("teacher", teacher);
		} else {
			model.addAttribute("message", "Update failure");
			model.addAttribute("teacher", headTeacher);
		}
		return "teacher";
	}
}
