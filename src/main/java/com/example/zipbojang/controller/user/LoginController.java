package com.example.zipbojang.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {
	
//	로그인 페이지 이동
	@RequestMapping("/login")
	public String loginPage() {
		return "user/login";
	}

// 로그인 처리	
	
	
}
