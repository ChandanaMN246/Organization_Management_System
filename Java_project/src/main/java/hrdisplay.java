

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/hrdisplay")
public class hrdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public hrdisplay() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "root");
		        Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery("SELECT * FROM hr")) {
			
		      response.setContentType("text/html");
		      request.getRequestDispatcher("back.html").include(request, response);
		      PrintWriter out = response.getWriter();
		      out.println("<!DOCTYPE html>");
		      out.println("<html>");
		      out.println("<head>");
		      out.println("<meta charset=\"UTF-8\">");
		      out.println("<title>ChanSrave's org</title>");
		      out.println("<style>");
		      out.println("body {");
		      out.println("  display: flex;");
		      out.println("  justify-content: center;");
		      out.println("  align-items: center;");
		      out.println("  height: 100vh;");
		      out.println("  background-color: #f2f2f2;");
		      out.println("}");
		      out.println(".container {");
		      out.println("  width: 600px;");
		      out.println("  padding: 20px;");
		      out.println("  background-color: #fff;");
		      out.println("  border: 1px solid #ccc;");
		      out.println("  border-radius: 5px;");
		      out.println("}");
		      out.println("table {");
		      out.println("  width: 100%;");
		      out.println("  border-collapse: collapse;");
		      out.println("  margin-bottom: 20px;");
		      out.println("}");
		      out.println("th, td {");
		      out.println("  padding: 8px;");
		      out.println("  border: 1px solid #ccc;");
		      out.println("}");
		      out.println("th {");
		      out.println("  background-color: #f2f2f2;");
		      out.println("  font-weight: bold;");
		      out.println("}");
		      out.println("</style>");
		      out.println("</head>");
		      out.println("<body>");
		      out.println("<div class=\"container\">");
		      out.println("<h2>HR Details</h2>");
		      out.println("<table>");
		      out.println("<tr>");
		      out.println("<th>Name</th>");
		      out.println("<th>Org ID</th>");
		      out.println("<th>Phone</th>");
		      out.println("<th>Email</th>");
		      out.println("<th>Role</th>");
		      out.println("<th>Recruiting Position</th>");
		      out.println("</tr>");

		      // Loop through the result set and generate table rows dynamically
		      while (resultSet.next()) {
		        String name = resultSet.getString("name");
		        String employeeId = resultSet.getString("id");
		        String phone = resultSet.getString("pnum");
		        String email = resultSet.getString("email");
		        String role = resultSet.getString("role");
		        String position = resultSet.getString("position");

		        out.println("<tr>");
		        out.println("<td>" + name + "</td>");
		        out.println("<td>" + employeeId + "</td>");
		        out.println("<td>" + phone + "</td>");
		        out.println("<td>" + email + "</td>");
		        out.println("<td>" + role + "</td>");
		        out.println("<td>" + position + "</td>");
		        out.println("</tr>");
		      }

		      out.println("</table>");
		      out.println("</div>");
		      out.println("</body>");
		      out.println("</html>");

		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
	}
}
