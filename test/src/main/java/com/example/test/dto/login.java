package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //(exclude = "id") - 아이디를 제거
@NoArgsConstructor // 기본생성자 X
@AllArgsConstructor // 모든 인자를 받는 생성자
@Builder
public class login {
	private String userid;
	private String userpw;
	
}
