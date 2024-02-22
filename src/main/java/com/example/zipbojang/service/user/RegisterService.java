package com.example.zipbojang.service.user;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.example.zipbojang.domain.UserDto;

@Service
public interface RegisterService {

	Map<String, String> userRegister (Errors errors);
	
//	회원가입
	void userSignUp(UserDto userdto);
	
//	이메일 중복확인
	int userIdChk(String user_email);
	
}
