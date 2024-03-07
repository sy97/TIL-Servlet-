import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test3Servlet extends HttpServlet {

	//post로 받기
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//이건 아무데나 적어주면안되고, 넘어온 순간 바꿔줘야함. 그러므로 맨 위에적어주도록하자.
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		/*
		//singer라는 name을 가진 값이 여러개이므로, 배열로 받아올 수 있는 getParameterValues써야함.
		String[] singers = req.getParameterValues("singer");
		//실제로 코드를 짤 때는 중간중간 테스트 하는것이 좋다.
		
		String[] foods = req.getParameterValues("food");
		String[] cities = req.getParameterValues("city");
		
		
		//사용자가 입력한 값 사용자에게 보여주기.
		//웹브라우저를 통해서 보여주겠다.
		PrintWriter out = resp.getWriter();
		
		//이렇게 html코드 다 짜줘야하는게 서블릿의 최대단점.
		out.println("<html><body>");
		out.println("<h2>당신이 가장 좋아하는 가수는 다음과 같습니다.</h2>");
		out.println("<ul>");
		for(int i = 0; i < singers.length; i ++) {
			out.println("<li>"+singers[i]+"</li>");
		}
		out.println("</ul>");
		
		out.println("<h2>당신이 가장 좋아하는 음식은 다음과 같습니다.</h2>");
		out.println("<ul>");
		
		//아무것도 체크하지않고 넘기면 콘솔에 null값 에러가나므로 if문
		if(foods != null) {
			for(String n : foods) {
			out.println("<li>" + n + "</li>");
			}
		}
		else {
			out.println("<li>선택한 값이 없습니다.</li>");
		}
		out.println("</ul>");
		
		out.println("<h2>당신이 좋아하는 도시는 다음과 같습니다.</h2>");
		out.println("<ul>");
		for(String c : cities) {
			out.println("<li>"+c+"</li>");
		}
		out.println("</ul>");
		
		
		
		out.println("</body></html>");
		out.close();
		*/
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		//변수 줄세우기
		Enumeration<String> en = req.getParameterNames();//singer, food, city라는 변수를 가져오는것.
		//줄세운 변수를 꺼내오기
		while(en.hasMoreElements()) {
			//처음에는 singer가 들어감.
			String name = en.nextElement();
			//하나라도 선택이 되어있는 경우에만 처리가 될 수 있게
			if(name != null) {
				//처음에는 singer가 들어가게됨.
				String[] values = req.getParameterValues(name);
				out.println("당신이 선택한 " + name + "은 다음과 같습니다.");
				out.println("<ul>");
				for(String s : values) {
					out.println("<li>"+ s +"</li>");
				}
				
				out.println("</ul>");
			}
		}
		
		out.println("</body></html>");
		out.close();
	}
	
}
