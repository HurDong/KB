package web0816.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindNumberMvcServlet
 */
@WebServlet("/FindNumberMvcServlet")
public class FindNumberMvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int targetNumber = new Random().nextInt(100) + 1;
	private String message = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindNumberMvcServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userGuess = Integer.parseInt(request.getParameter("number"));

		if (userGuess < targetNumber) {
			message = "입력한 숫자가 작습니다!";
		} else if (userGuess > targetNumber) {
			message = "입력한 숫자가 큽니다!";
		} else {
			message = "정답입니다! 게임이 끝났습니다.";
		}

		request.setAttribute("message", message);
		request.getRequestDispatcher("find_number_mvc.jsp").forward(request, response);
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
