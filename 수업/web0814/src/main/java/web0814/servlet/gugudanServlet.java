package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudanServlet")
public class gugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public gugudanServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		response.setCharacterEncoding("UTF-8");

		String userDan = request.getParameter("dan");

		int dan = Integer.parseInt(userDan);

		StringBuilder resultMessage = new StringBuilder();

		resultMessage.append("<h2>" + dan + "단 구구단</h2>");

		for (int i = 1; i <= 9; i++) {
			resultMessage.append(dan + " x " + i + " = " + dan * i + "<br>");
		}

		response.getWriter().write(resultMessage.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
