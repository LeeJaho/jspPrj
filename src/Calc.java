import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class Calc extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		
		/*OutputStream os = response.getOutputStream();*/
		
		/*PrintWriter out = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8), true);*/
		
		//PrintStream out = new PrintStream(os);
		int result = 0;

		String result_ = request.getParameter("result");
		if(result_ != null && !result_.equals(""))
			result = Integer.parseInt(result_);
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<div>");
		out.write("		<form action=\"add\" method=\"post\">");
		out.write("			<div>");
		out.write("				<label>덧셈</label>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<label>x:</label>");
		out.write("				<input type=\"text\" name=\"x\"/>"); /*--맞니?*/
		out.write("				<label>y:</label>");
		out.write("				<input type=\"text\" name=\"y\"/>");
		out.write("			</div>");
		out.write("				<div>");
		out.write("					<input id=\"btn-submit\" type=\"submit\" name=\"btn\" value=\"덧셈\"/>");
		out.write("					<input id=\"btn-app\" type=\"submit\" name=\"btn\" value=\"Application\"/>");
		out.write("					<input id=\"btn-session\" type=\"submit\" name=\"btn\" value=\"Session\"/>");
		out.write("					<input id=\"btn-cookie\" type=\"submit\"  name=\"btn\" value=\"Cookie\"/>");
		out.write("				</div>");
		out.write("			<div>result ");
		out.println("x + y = " + result);
		out.write("	<input type=\"hidden\" name=\"result\" value=\""+ result +"\" />");
		out.write("");
		/*<input type="hidden" name="result" value=\" +result+ \"/>*/
		out.write("			</div>");
		out.write("		</form>");
		out.write("	</div>");
		out.write("	<div>");
		out.write("<a href=\"mypage\">마이페이지</a>");
		out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();
		
		int result = 0;
			
		int x = 0;
		int y = 0;
		
		String tempX = request.getParameter("x");
		String tempY = request.getParameter("y");
		
		if(tempX != null && !tempX.equals(""))
			x= Integer.parseInt(tempX);
		
		if(tempY != null && !tempY.equals(""))
			y= Integer.parseInt(tempY);
			
		
		String btn="덧셈";
		//만약에 btn으로 전달된 값이 있다면
		//그 값을 btn 변수에 대입
		String btn_ = request.getParameter("btn");
		if(btn_ != null && !btn_.equals(""))
			btn = btn_;
		
		
		//btn에 따른 실행
		switch (btn) {
		case "덧셈":
			result = x + y;
			break;
			
		case "Application":{
			ServletContext application = request.getServletContext();
			String result_ = request.getParameter("result");
			application.setAttribute("result", result_);
		}
			break;
			
		case "Session":{
			HttpSession session = request.getSession();
			String result_ = request.getParameter("result");
			session.setAttribute("result", result_);
		}
			break;
			
		case "Cookie":{
			String result_ = request.getParameter("result");
			Cookie cookie = new Cookie("result", result_);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}
			break;
			
		default:
			break;
		}
		
		/*response.sendRedirect("add?result=" + result);*/
		response.sendRedirect(String.format("add?x=%d&y=%d&result=%d",x,y,result));

			
	}
	
	/*public void service1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		OutputStream os = response.getOutputStream();
		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8), true);
		
		//PrintStream out = new PrintStream(os);
		int result = 0;
		
		조건처리 -> POST했을 때만 돌게
		if(request.getMethod().equals("POST")) {
		int x = 0;
		int y = 0;
		String tempX = request.getParameter("x");
		String tempY = request.getParameter("y");
		
		if(tempX != null && !tempX.equals(""))
			x= Integer.parseInt(tempX);
		
		if(tempY != null && !tempY.equals(""))
			y= Integer.parseInt(tempY);
			
			result = x + y;
			
			response.sendRedirect("add.html");
		}

		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<div>");
		out.write("		<form action=\"add2\" method=\"post\">");
		out.write("			<div>");
		out.write("				<label>덧셈</label>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<input type=\"text\" name=\"x\"/>");
		out.write("				<input type=\"text\" name=\"y\"/>");
		out.write("			</div>");
		out.write("				<div>");
		out.write("					<input id=\"btn-submit\" type=\"submit\" value=\"덧셈\"/>");
		out.write("					<input id=\"btn-app\" type=\"submit\" value=\"Application\"/>");
		out.write("					<input id=\"btn-session\" type=\"submit\" value=\"Session\"/>");
		out.write("					<input id=\"btn-cookie\" type=\"submit\" value=\"Cookie\"/>");
		out.write("				</div>");
		out.write("			<div>result");
		out.println("x + y = " + (x+y));
		out.write("			</div>");
		out.write("		</form>");
		out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
		
		
	}*/
	

}
