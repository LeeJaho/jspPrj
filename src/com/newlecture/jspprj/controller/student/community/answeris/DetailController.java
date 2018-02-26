package com.newlecture.jspprj.controller.student.community.answeris;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.newlecture.jspprj.entity.AnswerisView;

@WebServlet("/student/community/answeris/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//내가 클릭한 글에 대한 id
		String id = request.getParameter("id");
		AnswerisDao answerisDao = new JdbcAnswerisDao();
		//answeris -> model (출력할 data)
		AnswerisView answeris = answerisDao.get(id);
		
		//request에 내용 보내기 위해 준비 -> 서블릿에서 서블릿으로 이동할 때 request에 내용저장한다
		request.setAttribute("answeris", answeris);
		//detail.jsp로 보내기 위한 준비 -> dispatcher
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/detail.jsp");
		
		//dispatch를 통해서 forward한다. request엔 answeris set 되어있음
		dispatcher.forward(request, response);
	
	}
}
