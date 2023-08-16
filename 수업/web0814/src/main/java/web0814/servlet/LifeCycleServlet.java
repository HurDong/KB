package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// Servlet 초기화 메서드
		System.out.println("** INIT() **");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp); // super 클래스에 있는 service 메서드를 부르므로 부모클래스에 있는 doGet, doPost를 호출
		// 요청마다 실행되는 메서드
		System.out.println("*** SERVICE ***");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청마다 실행되는 메서드
		System.out.println("*** DOGET ***");
	}

	@Override
	public void destroy() {
		// 객체 삭제시 실행되는 메서드
		System.out.println("*** DESTROY ***");
	}

}
