package servlet_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String searchWord = request.getParameter("searchWord");

		System.out.println("GET Request Parameters:");
		System.out.println("job: " + job);
		System.out.println("pageNo: " + pageNo);
		System.out.println("searchWord: " + searchWord);

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("<h1>GET Request Parameters:</h1>");
		response.getWriter().println("<p>job: " + job + "</p>");
		response.getWriter().println("<p>pageNo: " + pageNo + "</p>");
		response.getWriter().println("<p>searchWord: " + searchWord + "</p>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 폼에서 전송된 데이터의 인코딩 설정

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");

		System.out.println("POST Request Parameters:");
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Gender: " + gender);
		System.out.println("Hobbies: " + String.join(", ", hobbies));
		System.out.println("Favorite Investment: " + favorite);
		System.out.println("Description: " + desc);

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("<h1>POST Request Parameters:</h1>");
		response.getWriter().println("<p>Name: " + name + "</p>");
		response.getWriter().println("<p>Email: " + email + "</p>");
		response.getWriter().println("<p>Gender: " + gender + "</p>");
		response.getWriter().println("<p>Hobbies: " + String.join(", ", hobbies) + "</p>");
		response.getWriter().println("<p>Favorite Investment: " + favorite + "</p>");
		response.getWriter().println("<p>Description: " + desc + "</p>");
	}

}
