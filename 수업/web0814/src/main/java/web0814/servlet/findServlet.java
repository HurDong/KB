package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class findServlet
 */
@WebServlet("/findServlet")
public class findServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private int com_num = new java.util.Random().nextInt(100) + 1;

	public findServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String resultMessage;
		String userGuess = request.getParameter("num");
		try {
			int guess = Integer.parseInt(userGuess);
			if (guess < 1) {
				throw new IllegalArgumentException("1보다 작습니다");
			}
			if (guess > 100) {
				throw new IllegalArgumentException("100보다 큽니다");
			}
			if (guess < com_num) {
				resultMessage = "입력한 숫자가 작습니다!";
			} else if (guess > com_num) {
				resultMessage = "입력한 숫자가 큽니다!";
			} else {
				resultMessage = "정답입니다!";
			}

		} catch (Exception e) {
			e.printStackTrace();
			resultMessage = "잘못된 입력입니다." + e.getMessage();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(resultMessage);
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
