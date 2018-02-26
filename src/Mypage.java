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

@WebServlet("/mypage")
public class Mypage extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		int a = 0;
		int s = 0;
		int c = 0;
		
		/*String a_ = String.valueOf(application.getAttribute("result"));
		if(!a_.equals("null") && !a_.equals(""))
			a= Integer.parseInt(a_);*/
		
		//application servletContext에서 가져옴
		ServletContext application = request.getServletContext();
		Object a_ = application.getAttribute("result");
		if(a_ != null)
			a = Integer.parseInt((String)a_);
		
		/*String a_ = String.valueOf(application.getAttribute("result"));
		if(a_ != null && !a_.equals(""))
			a= Integer.parseInt(a_);*/
		
		//session에서 가져옴
		HttpSession session = request.getSession();
		Object s_ = session.getAttribute("result");
		if(s_ != null)
			s= Integer.parseInt((String)(s_));
		
		//cookie에서 가져옴 -> 요청할 때 -> response 해준걸 request 받아
		Cookie[] cookies = request.getCookies();
		String c_ = "";
		
		for(Cookie cook : cookies) {
			if(cook.getName().equals("result")) {
				c_ = cook.getValue();
				break;
			}
		}
		
		c = Integer.parseInt(c_);
		
		
		out.write("<html>");
		out.write("		<body>");
		out.write("			<div>application:" + a + "</div>");
		out.write("			<div>session:" + s + "</div>");
		out.write("			<div>cookie" + c + "</div>");
		out.write("			<div><a href=\"add\">계산하기</a></div>");
		out.write("		</body>");
		out.write("</html>");
		
	}
}
