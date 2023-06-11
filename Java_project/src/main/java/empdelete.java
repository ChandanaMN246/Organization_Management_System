

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class empdelete
 */
@WebServlet("/empdelete")
public class empdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public empdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String recordId = request.getParameter("recordId");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "root");
				PreparedStatement statement = connection.prepareStatement("DELETE FROM emp WHERE eid = ?")) {
			statement.setString(1, recordId);

            // Execute the delete statement
            int rowsAffected = statement.executeUpdate();

            // Create HTML response
            response.setContentType("text/html");
            request.getRequestDispatcher("back.html").include(request, response);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>ChanSrave's org</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Record Deletion</h2>");

            if (rowsAffected > 0) {
                out.println("<p>Record with ID " + recordId + " deleted successfully.</p>");
            } else {
                out.println("<p>No record found with ID " + recordId + ".</p>");
            }

            out.println("</body>");
            out.println("</html>");

        } catch (SQLException e) {
            e.printStackTrace();
        }
}


}
