package com.icia.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain=true)
@Data
@Builder  //빌더후 @AllArgsConstructor을 이용해 객체 생성함.
@NoArgsConstructor
@AllArgsConstructor
//Data Bean(dto,entity,vo)
//view(MemberDTO)--->controller-->service(DTO<--->Entity)--->DAO--->DB(table:MemberEntity)
public class Mem {
	private String username;
	private String password;
	private String role; 
}
