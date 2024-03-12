package com.icia.song.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true) // 체인 메서드 호출용
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	private String s_id;
	private String s_pw;
	private String s_name;
	private String s_birth;
	private String s_addr;
	private String s_phone;
	private Integer s_point;
	private String g_name;
}
