package memo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create01
 */
@WebServlet("/memo/create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	  * @see HttpServlet#HttpServlet()
	  */
	  public Create() {
	  super();
	  }

	/**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		String url = "jdbc:mysql://localhost:3306/mysql";
        String user = "root";
        String password = System.getenv("MYSQL_ROOT_PASSWORD");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO memo (title, content) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statment = connection.prepareStatement(sql)) {
               statment.setString(1, title);
               statment.setString(2, content);
               int number = statment.executeUpdate();
               request.setAttribute("message", "Successfully! Create post");
          } catch (Exception e) {
              request.setAttribute("message", "Execute exception:" + e.getMessage());
          }

		String forward = "/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}
}