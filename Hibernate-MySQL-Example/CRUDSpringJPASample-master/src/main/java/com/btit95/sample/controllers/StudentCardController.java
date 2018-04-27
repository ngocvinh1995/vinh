package com.btit95.sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.btit95.sample.entities.StudentCard;
import com.btit95.sample.repositories.StudentCardRepository;

@Controller
@RequestMapping("/cards")
public class StudentCardController {
	@Autowired
	private StudentCardRepository studentCardRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String cards(ModelMap model) {
		model.addAttribute("cards", (List<StudentCard>) studentCardRepository.findAll());
		return "cards";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editCard(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("card", studentCardRepository.findOne(id));
		return "card";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editCard(@ModelAttribute("card") StudentCard studentCard, ModelMap model) {
		StudentCard card = studentCardRepository.save(studentCard);
		if(null != card) {
			model.addAttribute("message", "Update success");
			model.addAttribute("teacher", card);
		} else {
			model.addAttribute("message", "Update failure");
			model.addAttribute("teacher", studentCard);
		}
		return "card";
	}
}
