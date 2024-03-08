package persistence;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookConfirm")
public class CookieConfirmServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//사용자컴퓨터에 저장되어있는 쿠키 꺼내서 사용자에게 확인시켜주기
		//현재 사용자의 쿠키 꺼내오는 메서드
		Cookie[] cooks = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h2>쿠키정보는 다음과 같습니다.</h2><br>");
		
		for(Cookie c : cooks) {
			out.println(c.getName()+","+c.getValue()+"<br>");
			//getname:키값, getvalue:데이터값
		}
		
		out.println("</body></html>");
		
		out.close();
	}

	
}
