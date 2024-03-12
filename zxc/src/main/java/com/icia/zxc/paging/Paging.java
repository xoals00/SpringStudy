package com.icia.zxc.paging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.icia.zxc.dao.BoardDao;
import com.icia.zxc.dto.BoardDto;
import com.icia.zxc.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paging {
	
	// 전체 글의 행의 수
	private int total;
	// 현재 페이지 번호
	private int nowPage;
	// 전체 페이지 개수
	private int totalPages;
	// 시작 페이지 번호
	private int startPage;
	// 종료 페이지 번호
	private int endPage;
	// 페이징의 개수
	private int pagingCount = 10;
	// 한 페이지에 보여질 게시글 갯수
	ArrayList<Integer> pList= new ArrayList<>();
	// 다음 페이지로 넘기기 위한 변수
	private int nextPage;
	private int newboard;
	private int size = 20;
	private int beforePage;
	public void makePaging(int total) {
		this.total = total;
		this.totalPages = (total/size);
//		if(nextPage != 0) {
//			setNowPage(nowPage+pagingCount);
//		}
		this.setNewboard((nowPage-1)*size);
		this.endPage = ((int)Math.ceil((double)nowPage/pagingCount))*pagingCount + this.nextPage;
		this.startPage = endPage-pagingCount+1;
		
		if(totalPages<endPage) {
			setEndPage(totalPages);
		}
		for(int i=startPage ; i<=endPage; i++) {
			this.pList.add(i);
		}
		this.nextPage = endPage +1;
		this.beforePage = startPage -1;
	}
	
}
