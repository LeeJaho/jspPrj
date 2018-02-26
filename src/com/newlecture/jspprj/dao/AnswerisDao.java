package com.newlecture.jspprj.dao;

import java.util.List;
import com.newlecture.jspprj.entity.Answeris;
import com.newlecture.jspprj.entity.AnswerisView;

//JdbcAnswerisDao / MyBatisAnswerisDao / SpringAnswerisDao
public interface AnswerisDao {
	
	/*--왜 int????*/
	int insert(Answeris answeris);
	int update(Answeris answeris);
	int delete(String id);
	
	List<AnswerisView> getList();
	AnswerisView get(String id);
}
