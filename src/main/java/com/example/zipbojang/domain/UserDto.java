package com.example.zipbojang.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDto {
		
		private int user_no;
		
		@NotBlank(message = "이메일을 입력해주세요.")
		@Email(message = "이메일 형식으로 입력해주세요.") 
		@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
		private String user_email;
		
		@NotBlank(message = "비밀번호를 입력해주세요.")
		@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$", message = "영문,숫자,특수문자 포함 8자리 이상이여야 합니다.")
		private String user_pw;
		
}
	


