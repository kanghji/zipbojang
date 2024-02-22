package com.example.zipbojang.controller.user;

import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.zipbojang.domain.UserDto;
import com.example.zipbojang.domain.common.Message;
import com.example.zipbojang.service.user.RegisterService;

@Controller
@RequestMapping("/user")
public class RegisterController {
	
	@Autowired 
	private RegisterService registerService;
	
	
//	회원가입 페이지 이동
	@GetMapping("/register")
	public String registerPage(UserDto userdto) {
		return "user/register";
	}
	
//	회원가입 
	@PostMapping("/register")
	public String register(@Valid UserDto userdto, Errors errors, Model model) {
		
//		 유효성 검사 실패시 
		if(errors.hasErrors()) {
			
			model.addAttribute("userdto", userdto);
	
			Map<String, String> validResult = registerService.userRegister(errors);
			
//			갖고온 모든 키로 반복문을 돌려서 키와 에러메시지를 매핑
			for(String key : validResult.keySet()) {
				System.out.println("key + validResult.get(key) = " +  key + " + " +  validResult.get(key));
				model.addAttribute(key, validResult.get(key));
			}
			return "user/register";
		}
		
//		이메일 중복 확인
		if(registerService.userIdChk(userdto.getUser_email()) != 0) {
			model.addAttribute("valid_user_email", "이미 등록된 이메일입니다.");
			return "user/register";
		}
		
		
//		유효성 검사 성공 시 회원가입 완료
		registerService.userSignUp(userdto);
		System.out.println("*********** 회원가입 성공 **********");
		
		return "redirect:/user/login";
	}
	
//	이용약관 페이지 이동
	@GetMapping("/agreeService")
	public String agreeServicePage() {
		return "user/agreeService";
	}
	
	@GetMapping("/agreeInfo")
	public String agreeInfoPage() {
		return "user/agreeInfo";
	}
}
