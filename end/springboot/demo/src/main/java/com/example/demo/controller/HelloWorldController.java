package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
@CrossOrigin
public class HelloWorldController {

	@Autowired
	private User user;

	@GetMapping("/")
	public String getUserInfo() {
		return user+":Hello SpringBoot!";
	}

	@PostMapping("/user")
	public User insertUser(User user) {
		return user;
	}

	@DeleteMapping("/user/{uid}")
	public User deleteUser(int uid) {
		User user = new User();
		user.setUid(uid);
		return user;
	}

	@PutMapping("/user")
	public User updateUser(User user) {
		return user;
	}

}