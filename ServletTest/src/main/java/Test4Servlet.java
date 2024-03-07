import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test4Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
	
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		
	
		Enumeration<String> en = req.getParameterNames();
		while(en.hasMoreElements()) {
			String name = en.nextElement();
			String[] values = req.getParameterValues(name);
			if(name != null) {
				if(name.equals("name")) {
				 String nameValue = values[0].toUpperCase();
				 out.println("<ul>");
				 out.print("사용자의" + name + "은(는) 다음과 같습니다.");
				 out.println("<li>" + nameValue + "</li>");
				 out.println("</ul>");
				}
				
				else {
				out.println("<ul>");
				out.print("사용자의 " + name + "은(는) 다음과 같습니다.");
				for(String s : values) {
					
					out.println("<li>"+ s +"</li>");
				}
				out.println("</ul>");
				}
				
			}
		
		}
		
		out.println("</body></html>");
		out.close();
	}
	

}
