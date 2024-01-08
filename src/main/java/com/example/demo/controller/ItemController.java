package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;


@Controller
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository; // seq:20.2
	
	@GetMapping("/items")	// 20.3
	public String index(Model model) {
		// すべての商品リストを取得
		List<Item> itemList = itemRepository.findAll(); // seq:20.6
		// 取得した商品リストをスコープに登録
		model.addAttribute("itemList", itemList);		// seq:20.8
		// 取得したカテゴリーリストをスコープに登録
		return "items";									// seq:20.9
	}
}
