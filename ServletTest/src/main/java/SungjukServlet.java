import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SungjukServlet extends HttpServlet {
	
	
	//데이터가 많지않고, 노출되었을 때 큰 피해가없는 데이터면 get방식으로.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//합계를 내려고하는데, 문자열이라서 바꿔줘야함.
		//wrapper클래스에 있는 parseint로 바꾸기. 
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		String calc = req.getParameter("calc");
		//사용자에게 응답하는 통로
		PrintWriter out = resp.getWriter();
		
		int result = 0;
		if(calc.equals("tot")) {
			result = kor + eng + math;
			out.println("<html><body>");
			out.println("총점 : " + result);		
			out.println("</body></html>");
		}
		else {
			result = (kor + eng + math) / 3;
			out.println("<html><body>");
			out.println("평균 : " + result);		
			out.println("</body></html>");

		}
		
		out.close();
		
	}
	
	
}
