package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Item;
import com.example.demo.model.Cart;

@Controller
public class CartController {
	
	@Autowired // seq:32.1
	Cart cart;
	
	@GetMapping("/cart") // seq:31.1
	public String index() {
		// 仮のカートを設定（削除予定）
		Item item = new Item();
		item.setId(2);
		item.setCategoryId(1);
		item.setName("超芸術トマソン");
		item.setPrice(2480);
		item.setQuantity(1);
		cart.getItems().add(item);
		// ここまで
		return "cart";   // seq:31.2
	}
	
}
