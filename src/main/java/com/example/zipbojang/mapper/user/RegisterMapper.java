package com.example.zipbojang.mapper.user;

import org.apache.ibatis.annotations.Mapper;

import com.example.zipbojang.domain.UserDto;

@Mapper
public interface RegisterMapper {	
	
//	회원가입
	void userSignUp(UserDto userdto);
	
//	아이디 중복체크
	int userIdChk(String user_email);
	
	 
}
