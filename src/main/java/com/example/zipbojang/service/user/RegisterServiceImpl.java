package com.example.zipbojang.service.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.example.zipbojang.domain.UserDto;
import com.example.zipbojang.mapper.user.RegisterMapper;


@Service
@Transactional(readOnly=false)
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired 
	private RegisterMapper registerMapper;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Map<String, String> userRegister(Errors errors) {
		
		Map<String, String> validResult = new HashMap<>();
	
		for(FieldError error : errors.getFieldErrors()) {
			
			String validName = "valid_" + error.getField();
			validResult.put(validName, error.getDefaultMessage());
			
			System.out.println("실패 필드명 : " + validName);
			System.out.println("유효성 실패 메세지 : " + error.getDefaultMessage());
			System.out.println("바인딩 실패 이유 : " + error.isBindingFailure());
		}
		return validResult;
}
	
//	이메일 중복확인
	@Override
	public int userIdChk(String user_email) {
		return registerMapper.userIdChk(user_email);
	}
	
	@Override
	public void userSignUp(UserDto userdto) {
//		비밀번호 암호화
		System.out.println("userDto = " + userdto);
		userdto.setUser_pw(passwordEncoder.encode(userdto.getUser_pw()));
		registerMapper.userSignUp(userdto);
	}

	
	
	
	
	


	
	
	
}
