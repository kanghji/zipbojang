package com.example.zipbojang.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {
	
	@RequestMapping("/admin")
	public String adminRoot( ) {
		return "admin/adminHome";
	}
}
