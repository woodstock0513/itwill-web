package com.itwill.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeContoller {
	
	@GetMapping("/")
	public String Home() {
		log.info("Home()");
		return "index";
	}
	
	
	
}
