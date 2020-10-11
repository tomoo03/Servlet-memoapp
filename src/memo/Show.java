package memo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show
 */
@WebServlet("/memo/show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		int postId = Integer.parseInt(request.getParameter("id"));
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = "root";
		String password = System.getenv("MYSQL_ROOT_PASSWORD");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e){
			e.printStackTrace();
		}

		String sql = "SELECT * FROM memo WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statment = connection.prepareStatement(sql)) {

			statment.setInt(1, postId);
			ResultSet results = statment.executeQuery();

			while (results.next()) {
				String id = results.getString("id");
				request.setAttribute("id", id);

				String title = results.getString("title");
				request.setAttribute("title", title);

				String content = results.getString("content");
				request.setAttribute("content", content);
			}
		} catch (Exception e) {
			request.setAttribute("message", "Exception:" + e.getMessage());
		}

		String view = "/show.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
