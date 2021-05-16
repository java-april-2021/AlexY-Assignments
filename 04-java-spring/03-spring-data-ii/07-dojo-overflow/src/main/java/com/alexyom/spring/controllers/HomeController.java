package com.alexyom.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alexyom.spring.services.QuestionService;

@Controller
public class HomeController {
	@Autowired
	private QuestionService qService;
	
	//Home Page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", qService.getAllQuestions());
		return "index.jsp";
	}
}
