package workshop0816.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import dto.ParameterDto;

@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// test by browser address with query string
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 서버에서 읽는 경우는 GET 방식에서는 없어도 된다. 하지마, 항상 해 주도록 향후에는 Filter 등으로 처리
		// 브라우저에 보내는 경우는 한글 처리 필요.

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 파라미터 처리하기
		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String searchWord = request.getParameter("searchWord");

		// 서버 출력
		System.out.println("job : " + job);
		System.out.println("pageNo : " + pageNo);
		System.out.println("searchWord : " + searchWord);

		// Map 에 담기
		Map<String, String> map = new HashMap<>();
		map.put("job", job);
		map.put("pageNo", pageNo);
		map.put("searchWord", searchWord);

		// request 에 담기
		request.setAttribute("map", map);

		// forwarding 하기
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getResult.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // need with POST
		response.setContentType("text/html; charset=utf-8");

		// 파라미터 처리하기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String hobby[] = request.getParameterValues("hobby");
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");

		// 서버 출력
		System.out.println("name : " + name);
		System.out.println("email : " + email);
		System.out.println("gender : " + gender);
		System.out.println("hobby : " + Arrays.toString(hobby));
		System.out.println("favorite : " + favorite);
		System.out.println("desc : " + desc);

		// ParrameterDto 에 담기
		ParameterDto parameterDto = new ParameterDto(name, email, gender, hobby, favorite, desc);

		// request 에 담기
		request.setAttribute("parameterDto", parameterDto);
		
		// forwarding 하기
		RequestDispatcher dispatcher = request.getRequestDispatcher("/postResult.jsp");
		dispatcher.forward(request, response);
	}

}
