import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHeader extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	//지금부터 내가 출력하는 모든것은 html이다.라는 뜻. 입력값을 모두 html로 해석해서 내보내줌.
	resp.setContentType("text/html");
	
	Enumeration e = req.getHeaderNames();
	while(e.hasMoreElements()) {
		out.println(e.nextElement()+"<br>");
	}
	
	out.println("<hr/>");
	out.println("host : " + req.getHeader("host")+"<br>");
	out.println("sec-ch-ua : " + req.getHeader("sec-ch-ua")+"<br>");
	out.println("sec-ch-ua-platform : " + req.getHeader("sec-ch-ua-platform")+"<br>");
	out.println("user-agent : " + req.getHeader("user-agent")+"<br>");
	out.println("accept-language : " + req.getHeader("accept-language")+"<br>");
	//누가 접속했는지 확인
	out.println("Client IP : " + req.getRemoteAddr());
	
	
	
	
	
	out.close();
	
	}
	
}
