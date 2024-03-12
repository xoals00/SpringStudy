package com.icia.myBoard.Dto;

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
public class commentDto {
	private int bCnt;
	private int cCnt;
	private String userId;
	private String cDetail;
}
