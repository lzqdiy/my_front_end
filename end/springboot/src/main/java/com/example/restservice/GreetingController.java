package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.domain.User;

@RestController
@CrossOrigin
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private User user;

	@GetMapping("/")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		// return new Greeting(counter.incrementAndGet(), String.format(template, name));
		return user.getUsername()+":Hello SpringBoot!";
	}
}
