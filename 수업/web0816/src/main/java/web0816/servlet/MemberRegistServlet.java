package web0816.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0816.dto.MemberDto;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/memberRegistServlet")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberRegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDto dto = new MemberDto();
		String name = request.getParameter("name");
		dto.setName(name);
		String sage = request.getParameter("age");
		int age = Integer.parseInt(sage);
		dto.setAge(age);
		// 생성한 dto를 request에 속성으로 저장
		request.setAttribute("dto", dto);
		request.setAttribute("msg", "Hello");
		// memberRegist2.jsp로 포워드
		request.getRequestDispatcher("/memberRegist2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
