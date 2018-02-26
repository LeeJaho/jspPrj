package com.newlecture.jspprj.controller.student.community.answeris;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.newlecture.jspprj.entity.AnswerisView;



@WebServlet("/student/community/answeris/list")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AnswerisDao answerisDao = new JdbcAnswerisDao();
		List<AnswerisView> list = answerisDao.getList();
	
		
		//request에 내용 보내기 위해 준비 -> 서블릿에서 서블릿으로 이동할 때 request에 내용저장한다
		request.setAttribute("list", list);
		//detail.jsp로 보내기 위한 준비 -> dispatcher
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/list.jsp");
		
		//dispatch를 통해서 forward한다. request엔 answeris set 되어있음
		dispatcher.forward(request, response);
	}

}
