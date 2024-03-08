package persistence;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
	
		//세션은 자동으로 생성되는거임. 쿠키처럼 객체생성해서 만드는거 아님
		//세션은 사용자가 요청할 때 만들어지는거니까 req에 있음.
		
		//리턴값은 세션
		//사용자만 사용할 수 있는 공간을 가져오게된것.
		HttpSession session = req.getSession();
		//그 공간에 있는 값을 가져오기.
		session.setAttribute("name", name);
		session.setAttribute("addr", addr);
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println(session.getAttribute("name") + "님 환영합니다.<br>");
		out.println("</body></html>");
		
		out.close();
	}
	
 
}
