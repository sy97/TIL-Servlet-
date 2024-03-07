import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTest extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("serivce() call");
		//사용자가 어떤 방식으로 요청했는지 확인 가능.
		System.out.println(arg0.getMethod());
	}

	@Override
	public void destroy() {
		System.out.println("destroy() call");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() call");
	}
	
}
