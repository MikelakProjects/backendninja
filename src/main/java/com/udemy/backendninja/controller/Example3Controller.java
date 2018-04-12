package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEV = "result";
	
	@GetMapping("/showform")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		ModelAndView mav = new ModelAndView(RESULT_VIEV);
		mav.addObject("person", person);
		return mav;
	}
}
