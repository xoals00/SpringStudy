package com.icia.zxc.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.tomcat.util.modeler.BaseNotificationBroadcaster;

import com.icia.zxc.dto.BoardDto;
import com.icia.zxc.paging.Paging;

@Mapper
public interface BoardDao {

	List<HashMap<String, String>>  showboard(Paging paging);

	HashMap<String, String> boardread(BoardDto boardDto);

	int boardinfo(BoardDto boardDto);

	int boardupdate(BoardDto boardDto);

	int boarddelete(BoardDto boardDto);

}
