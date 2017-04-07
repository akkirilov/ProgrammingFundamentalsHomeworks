package com.softuni.controller;

import com.softuni.Models.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");

		return "base-layout";
	}

	@PostMapping("/")
	public String index(
			@RequestParam String leftOperand,
			@RequestParam String operator,
			@RequestParam String rightOperand,
			Model model
			) {
		int leftNum;
		int rightNum;

		try{
			leftNum = Integer.parseInt(leftOperand);
		}
		catch (Exception ex){
			leftNum = 0;
		}

		try {
			rightNum = Integer.parseInt(rightOperand);
		}
		catch (Exception ex){
			rightNum = 0;
		}

		Calculator calculator = new Calculator(leftNum, operator, rightNum);
		double result = calculator.calculate();

		model.addAttribute("leftOperand", leftOperand);
		model.addAttribute("rightOperand", rightOperand);
		model.addAttribute("operator", operator);
		model.addAttribute("result", result);
		model.addAttribute("view", "views/calculatorForm");

		return "base-layout";
	}
}