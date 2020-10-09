package memo;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index01
 */
@WebServlet("/memo/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	  * @see HttpServlet#HttpServlet()
	  */
	  public Index() {
	  super();
	  }

	/**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
        out.println("<head>");
        out.println("<title>サーブレットのサンプル</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>サーブレットのサンプル</h1>");
        out.println("</body>");
        out.println("</html>");

		String greeting = "Good Morning!";
		System.out.println("HttpServletに" + greeting + "を設定");

		request.setAttribute("greeting", greeting);

		String url = "/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}