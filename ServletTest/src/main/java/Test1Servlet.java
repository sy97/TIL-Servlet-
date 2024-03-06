import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = null;
		try{
			//한글 깨지지 않게
			req.setCharacterEncoding("euc-kr");
			resp.setCharacterEncoding("euc-kr");
		
			String name = req.getParameter("name");
			String addr = req.getParameter("addr");
			//사용자가입력한 값을 꺼내서 변수에 저장
		
			
			out = resp.getWriter();
			//어떤 장치로 출력할것인지 넘겨주는 메서드. 따로 정해져있지 않을 땐 웹브라우저.
			out.println("<html><body>");
			out.println("<h1>Request Test</h1>");
			
			//req가 어떤 방식인지 알고있으니까 물어본다음, post방식이면 아래처럼 나오게.
			if(req.getMethod().equals("POST")){
			out.println("이것은 Post방식으로 처리된 내용입니다.<br>");
			}
			
			out.println("This is data you sent.<br>");
			out.println("Name is " + name + ", Address is " + addr + ".");
			out.println("</body></html>");
		
		}
		catch(Exception e){}
		finally{
			out.close();
		}
	}

}
