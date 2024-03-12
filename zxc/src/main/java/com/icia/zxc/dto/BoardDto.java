package com.icia.zxc.dto;

import com.icia.zxc.dto.BoardDto;

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
public class BoardDto {
	private int bCnt;	
	private String userId;
	private String bTitle;
	private String bDetail;
		
	
}
