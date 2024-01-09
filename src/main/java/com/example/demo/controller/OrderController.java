package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Cart;

@Controller
public class OrderController {
	
	@Autowired // seq:41.1
	Cart cart;
	
	@GetMapping("/order")      // seq:41.2
	public String index() {
		return "customerForm"; // seq:41.3
	}
	
}
