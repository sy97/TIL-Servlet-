package persistence;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessConfirm")
public class SessConfirmServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//사용자컴퓨터에 세션정보 보여주기 
		HttpSession session = req.getSession();
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h2>세션정보는 다음과 같습니다.</h2><br>");
		out.println(session.getAttribute("name")+"님 환영합니다.<br>");
		out.println("주소는 " + session.getAttribute("addr")+"<br>");
		
		//세션이 만들어진 시간 : 사용자가 접속한 시간. 몇시에 접속했는지 알 수 있음.
		out.println("Connection Time : " + new Date(session.getCreationTime())+"<br>");
		//세션이 만료기한.
		out.println("Expired Time : " + session.getMaxInactiveInterval()+"<br>");
		//처음 접속인지 아닌지. 처음이면 true.
		out.println("New : " + session.isNew()+"<br>");
		
		out.println("</body></html>");
		
		out.close();
	}


}
