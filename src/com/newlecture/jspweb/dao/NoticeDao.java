package com.newlecture.jspweb.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.jspweb.entity.Notice;
import com.newlecture.jspweb.entity.NoticeView;

public interface NoticeDao {

	List<NoticeView> getList();
	/*List<Notice> getList(String query);
	List<Notice> getList(int page);
	List<Notice> getList(int page, String field, String query);*/
	
	/*--(공지사항 페이지에서 필요한 것들 확인 후 ) 공지사항을 요청-----------*/	
	NoticeView get(String id);
	NoticeView getNext(String id);
	NoticeView getPrev(String id);
	
	int insert(NoticeView notice);
	int update(NoticeView notice);
	int delete(String id);
}
