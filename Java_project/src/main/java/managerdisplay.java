

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/managerdisplay")
public class managerdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public managerdisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "root");
		        Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery("SELECT * FROM manager")) {
			
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
		      out.println("  width: 900px;");
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
		      out.println("<h2>Employee Details</h2>");
		      out.println("<table>");
		      out.println("<tr>");
		      out.println("<th>Name</th>");
		      out.println("<th>Manager ID</th>");
		      out.println("<th>Phone</th>");
		      out.println("<th>Email</th>");
		      out.println("<th>Team Members1</th>");
		      out.println("<th>Team Members2</th>");
		      out.println("<th>Team Members3</th>");
		      out.println("<th>Current Project</th>");
		      out.println("</tr>");

		      // Loop through the result set and generate table rows dynamically
		      while (resultSet.next()) {
		        String name = resultSet.getString("name");
		        String employeeId = resultSet.getString("id");
		        String phone = resultSet.getString("pnum");
		        String email = resultSet.getString("email");
		        String members1 = resultSet.getString("memb1");
		        String members2 = resultSet.getString("memb2");
		        String members3 = resultSet.getString("memb3");
		        String currentProject = resultSet.getString("proj");

		        out.println("<tr>");
		        out.println("<td>" + name + "</td>");
		        out.println("<td>" + employeeId + "</td>");
		        out.println("<td>" + phone + "</td>");
		        out.println("<td>" + email + "</td>");
		        out.println("<td>" + members1 + "</td>");
		        out.println("<td>" + members2 + "</td>");
		        out.println("<td>" + members3 + "</td>");
		        out.println("<td>" + currentProject + "</td>");
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
