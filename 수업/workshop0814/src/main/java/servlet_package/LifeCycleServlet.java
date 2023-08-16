package servlet_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet() is called!!!");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() is called!!!");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() is called!!!");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("<h1>안녕하세요, LifeCycleServlet 입니다.</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("*** DOPOST ***");
		doGet(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("*** DESTROY ***");
	}
}
