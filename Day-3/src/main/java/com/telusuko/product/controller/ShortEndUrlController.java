package com.telusuko.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusuko.product.entity.ShortEndUrl;
import com.telusuko.product.service.ShortEndService;


@RestController
@RequestMapping("/url")
@CrossOrigin(origins = "http://localhost:3000")
public class ShortEndUrlController {
	
	@Autowired
	private ShortEndService service;
	
	@PostMapping
	public String saveUrl(@RequestBody String url) {
		return service.saveUrl(url);
		
	}
//	@GetMapping
//	public String getShortUrl(String url) {
//		
//		return service.generateURL(getShortUrl(url));
//		
//	}

}
