package com.learning.passGenerator.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learning.passGenerator.form.PassConfiguration;

@Controller
public class MainController {
	
	private Random random = new Random();
	
	private String loverChars = "abcdefghijklmnopqrstuvwxyz";
	private String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String nums = "0123456789";
	private String symbols = "!@#$%&*()_+-=[]|,./?><";		
		
	@GetMapping("/")
	public String mainGet(Model model) {
		model.addAttribute("inputConfiguration" , new PassConfiguration());

		return "index";
	}
	
	@PostMapping("/")
	public String mainPost(Model model,
			@ModelAttribute("inputConfiguration") PassConfiguration config) {

		String ableChars = "";
		String pass = "";
		
		if(config.isUseLower())
			ableChars += loverChars;
		if(config.isUseUpper())
			ableChars += upperChars;
		if(config.isUseNums())
			ableChars += nums;
		if(config.isUseSymbols())
			ableChars += symbols;
		
		for(int i=0; i < config.getLength(); ++i) {
			pass += ableChars.charAt(random.nextInt(ableChars.length()));
		}
		model.addAttribute("pass", pass);
		
		return "index";
	}
}
