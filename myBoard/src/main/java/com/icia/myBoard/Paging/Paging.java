package com.icia.myBoard.Paging;

import java.util.ArrayList;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paging {
	// 전체 글 수 
	private int total;
	// 현재 페이지
	private int nowPage;
	// 전체 페이지 
	private int totalPages;
	// 시작 페이지
	private int startPage;
	// 끝나는 페이지
	private int endPage;
	// 페이지에 보여질 번호 갯수
	private int pagingCount = 10;
	// 다음 페이지
	private int nextPage;
	// 이전 페이지
	private int beforePage;
	// 페이지에 보여질 게시글 수
	ArrayList<Integer> pList= new ArrayList<>();
	// 보여질 개시글 수
	private int size = 20;
	// 리미트로 게산할 게시글
	private int newboard;
	
	
	public void makePaging(int total) {
		this.total = total;
		this.totalPages = (total/size);
		
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
