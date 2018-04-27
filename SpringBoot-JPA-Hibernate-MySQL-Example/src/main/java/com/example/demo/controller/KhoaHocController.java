package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.KhoaHoc;
import com.example.demo.service.KhoaHocService;

@Controller
public class KhoaHocController {

	@Autowired
	private KhoaHocService khoahocService;
	
	@RequestMapping(value= {"/khoahoc-list" })
	public String listStudent(Model model) {
		
		model.addAttribute("listKhoaHoc" , khoahocService.findAll());
		
		return "khoahoc-list";
		
	}
	@RequestMapping("/khoahoc-save")
	public String insertStudent(Model model) {
		
		model.addAttribute("khoahoc" , new KhoaHoc());
		return "khoahoc-save";
	}
	
	 @RequestMapping("/khoahoc-view/{MaSV}")
	  public String viewStudent(@PathVariable Model model , int MaKH) {
	   
	    
	    KhoaHoc khoahoc = khoahocService.findById(MaKH);
	    model.addAttribute("khoahoc" , khoahoc);
	    
	    return "khoahoc-view";
	  }
	  
	  @RequestMapping("/khoahoc-update/{MaKH}")
	  public String updateStudent(@PathVariable Model model , int MaKH) {
	    
	    KhoaHoc khoahoc = khoahocService.findById(MaKH);
	    model.addAttribute("khoahoc", khoahoc);
	    
	    return "khoahoc-update";
	  }
	  
	  @RequestMapping("/saveKhoahoc")
	  public String doSaveKhoahoc(@ModelAttribute("KhoaHoc") KhoaHoc khoahoc, Model model) {
	    khoahocService.save(khoahoc);
	    model.addAttribute("listKhoaHoc", khoahocService.findAll());
	    return "redirect:khoahoc-list";
	  }
	  
	  @RequestMapping("/updateKhoaHoc")
	  public String doUpdateKhoaHoc(@ModelAttribute("KhoaHoc") KhoaHoc khoahoc, Model model) {
		  khoahocService.update(khoahoc);
	    model.addAttribute("listKhoaHoc", khoahocService.findAll());
	    return "redirect:khoahoc-list";
	  }
	  
	  @RequestMapping("/studentKhoaHoc/{id}")
	  public String doDeleteKhoaHoc(@PathVariable int id, Model model) {
		  khoahocService.delete(id);
	    model.addAttribute("listKhoaHoc", khoahocService.findAll());
	    return "redirect:/khoahoc-list";
	  }
	
}
