import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test4ServletEdit extends HttpServlet {

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
			out.println("<ol>");
			for(String v : values) {
				if(name != null) {
					if(name.equals("name")) {
						String upper_v = v.toUpperCase();
						out.println("<h2>"+name+" : "+upper_v+"</h2>");
					}
					else
						out.println("<h2>"+name+" : "+v+"</h2>");
				}
				
				else {
					out.println("<h2>"+name+" : 입력값이 없습니다.</h2>");
				}
			}
			
			out.println("<ol>");
			
		}
		
		out.println("</body></html>");
		out.close();
	}
	

}

