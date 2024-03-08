package persistence;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cook")
public class CookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		
		//단순히 화면에 보여줄뿐만 아니라, 사용자 컴퓨터에 저장시켜줄것.
		//쿠키로 저장하려면 쿠키로 먼저 포장해줘야함.
		Cookie cookName = new Cookie("name", name);
		Cookie cookAddr = new Cookie("addr", addr);
		
		//사용자 컴퓨터에 얼마동안 저장시킬지 기간 정해줘야함.
		cookName.setMaxAge(60 * 60 * 24); //하루
		cookAddr.setMaxAge(60 * 60 * 24);
		
		//resp 통해서 보내주기.
		resp.addCookie(cookName);
		resp.addCookie(cookAddr);
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("쿠키가 잘 저장되었습니다.<br>");
		out.println("이름은 " + name + "입니다.<br>");
		out.println("주소는 " + addr + "입니다.<br>");
		out.println("</body></html>");
		
		out.close();
	}
	
}
