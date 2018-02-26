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

@WebServlet("/add2")
public class Nana2 extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		/*OutputStream os = response.getOutputStream();*/
		
		/*PrintWriter out = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8), true);*/
		
		//PrintStream out = new PrintStream(os);
		
		int x = 0;
		int y = 0;
		String tempX = request.getParameter("x");
		String tempY = request.getParameter("y");
		
		if(tempX != null && !tempX.equals(""))
			x= Integer.parseInt(tempX);
		
		if(tempY != null && !tempY.equals(""))
			y= Integer.parseInt(tempY);
		
		
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
		out.write("				<input type=\"text\" name=\"x\"/>");
		out.write("				<input type=\"text\" name=\"y\"/>");
		out.write("				<div>");
		out.write("					<input id=\"btn-submit\" type=\"submit\" value=\"덧셈\"/>");
		out.write("					<input id=\"btn-app\" type=\"submit\" value=\"Application\"/>");
		out.write("					<input id=\"btn-session\" type=\"submit\" value=\"Session\"/>");
		out.write("					<input id=\"btn-cookie\" type=\"submit\" value=\"Cookie\"/>");
		out.write("				</div>");
		out.write("			</div>");
		out.write("			<div>result");
		out.println("x + y = " + (x+y));
		out.write("			</div>");
		out.write("		</form>");
		out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
		
		
	}
}
