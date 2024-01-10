package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.model.Cart;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;



@Controller
public class OrderController {
	
	@Autowired // seq:41.1
	Cart cart;
	
	@Autowired // seq:43.2
	CustomerRepository customerRepository;
	
	@Autowired // seq:43.3
	OrderRepository orderRepository;
	
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
	
	@PostMapping("/order") // 43.5
	public String order(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "email", defaultValue = "") String email,
			Model model) {
		
		// 顧客情報の永続化
		// リクエストパラメータをもとに顧客のインスタンスを生成
		Customer customer = new Customer(name, address, tel, email); // seq:43.6
		// 顧客インスタンスの永続化
		customerRepository.save(customer); // seq:43.7
		
		// 注文永続化
		// リクエストパラメータをもとに注文のインスタンスを生成
		LocalDate today = LocalDate.now();         // seq:43.8
		Integer customerId = customer.getId();     // seq:43.9
		Integer totalPrice = cart.getTotalPrice(); // seq:43.10
		Order order = new Order(customerId, today, totalPrice); // seq:43.11
		// 注文インスタンのインスタンス化
		orderRepository.save(order); // seq:43.12
		
		// 画面遷移
		return "ordered"; // seq:43.
	}
	
	
}
