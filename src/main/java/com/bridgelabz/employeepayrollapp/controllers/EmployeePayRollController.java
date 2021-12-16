package com.bridgelabz.employeepayrollapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePayRollController {
	
	@RequestMapping("/get")
	public String getData() {
		return "Working";
	}

}
