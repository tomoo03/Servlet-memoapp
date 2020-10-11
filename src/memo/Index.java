package memo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

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

		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = "root";
		String password = System.getenv("MYSQL_ROOT_PASSWORD");

	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    String sql = "SELECT * FROM memo";

	    try (Connection connection = DriverManager.getConnection(url, user, password);
	    	PreparedStatement statment = connection.prepareStatement(sql);
	    	ResultSet results = statment.executeQuery()) {

	    	ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
	    	while (results.next()) {
	    		HashMap<String, String> columns = new HashMap<String, String>();

	    		String id = results.getString("id");
	    		columns.put("id", id);

	    		String title = results.getString("title");
	    		columns.put("title", title);

	    		String content = results.getString("content");
	    		columns.put("content", content);

	    		rows.add(columns);
	    	}

	    	request.setAttribute("rows", rows);
	    } catch (Exception e) {
	    	request.setAttribute("message", "Exception:" + e.getMessage());
	    }

		String greeting = "Good Morning!";
		System.out.println("HttpServletに" + greeting + "を設定");

		request.setAttribute("greeting", greeting);

		String forward = "/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}
}