package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
@CrossOrigin
public class HelloWorldController {

	@Autowired
	private User user;

	@GetMapping("/")
	public String greeting() {
		return user.getUsername()+":Hello SpringBoot!";
	}
}