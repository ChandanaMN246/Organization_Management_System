
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class emp
 */
@WebServlet("/emp")
public class emp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name,email,dep,proj,manager;
	int id,pno;
	
     Connection c;
     Statement s=null;
     ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try {
			out.println("Started");
			Class.forName("com.mysql.jdbc.Driver");
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/organization","root","root");
			  out.println("Connection Established....");
			  
		}
		catch(Exception e)
		{
			  System.out.println(e);
		}
		name=req.getParameter("name");
		id=Integer.parseInt(req.getParameter("emp_id"));
		pno=Integer.parseInt(req.getParameter("phone"));
		email=req.getParameter("email");
		dep=req.getParameter("department");
		proj=req.getParameter("current_project");
		manager=req.getParameter("manager");
		try {
			Statement s= c.createStatement();
			  System.out.println("done");
			  String q="insert into emp values('"+name+"',"+id+", "+pno+", '"+email+"','"+dep+"' ,'"+proj+"', '"+manager+"')";
			  s.executeUpdate(q);
			  out.println("data insert succssfull");
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		req.getRequestDispatcher("operation.html").include(req, res);
	}

}
