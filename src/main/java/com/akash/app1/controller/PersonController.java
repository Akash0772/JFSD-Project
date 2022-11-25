package com.akash.app1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.app1.entity.Person;
import com.akash.app1.service.PersonService;

@RestController
@CrossOrigin
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("signup")
	public Person signup(@RequestBody Person person) {
		return personService.signup(person);
	}
	
	@PostMapping("login")
	public boolean login(@RequestBody Person person) {
		return personService.login(person);
	}
	
	@GetMapping("login")
	public boolean login() {
		return true;
	}
}
