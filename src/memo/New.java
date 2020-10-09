package memo;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class New01
 */
@WebServlet("/memo/new")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	  * @see HttpServlet#HttpServlet()
	  */
	  public New() {
	  super();
	  }

	/**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String testMessage = "新規作成";
		System.out.println("HttpServletに" + testMessage + "を設定");

		request.setAttribute("testMessage", testMessage);

		String url = "/new.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}