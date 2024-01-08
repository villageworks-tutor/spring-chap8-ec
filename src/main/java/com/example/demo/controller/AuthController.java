package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;


@Controller
public class AuthController {
	
	@Autowired // seq:12.1
	Account account;
	
	@GetMapping("/")	// seq:11.1
	public String index() {
		return "login"; // seq:11.2
	}
	
	@PostMapping("/login")	// seq:12.2
	public String login(@RequestParam("name") String name) {
		account.setName(name); // seq:12.3
		return "items"; // seq:12.4
	}
	
	
}
