package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.model.Cart;


@Controller
public class OrderController {
	
	@Autowired // seq:41.1
	Cart cart;
	
	@GetMapping("/order")      // seq:41.2
	public String index() {
		return "customerForm"; // seq:41.3
	}
	
	@PostMapping("/order/confirm") // sqe:42.1
	public String confirm(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "email", defaultValue = "") String email,
			Model model) {
		// リクエストパラメータをもとに顧客のインスタンスを生成
		Customer customer = new Customer(name, address, tel, email); // seq:42.2
		// 生成した顧客インスタンスをスコープに登録
		model.addAttribute("customer", customer); // seq:42.3
		// 画面遷移
		return "customerConfirm"; // seq:42.4
	}
	
	
}
