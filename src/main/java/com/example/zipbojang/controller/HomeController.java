package com.example.zipbojang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
class HomeController {
	@RequestMapping("/")
	public String root() {
		return "home/home";
	}
}
