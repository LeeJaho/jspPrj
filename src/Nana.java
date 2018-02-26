import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hell")
public class Nana extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		/*OutputStream os = response.getOutputStream();*/
		
		/*PrintWriter out = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8), true);*/
		
		//PrintStream out = new PrintStream(os);
		
		int cnt = 0;
		String temp = request.getParameter("cnt");
		
		if(temp != null && !temp.equals(""))
			cnt= Integer.parseInt(temp);
		
		for(int i = 0; i < cnt; i++)
			out.println("안녕 Servlet<br />");
	}
}
