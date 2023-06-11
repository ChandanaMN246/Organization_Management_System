

import java.io.*;
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
 * Servlet implementation class manager
 */
@WebServlet("/manager")
public class manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name,pnum,email,m1,m2,m3,proj;
	int id;
	
     Connection c;
     Statement s=null;
     ResultSet rs=null;
  
    public manager() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		id=Integer.parseInt(req.getParameter("manager_id"));
		pnum=req.getParameter("phone");
		email=req.getParameter("email");
		m1=req.getParameter("team_members1");
		m2=req.getParameter("team_members2");
		m3=req.getParameter("team_members3");
		proj=req.getParameter("current_project");
		try {
			Statement s= c.createStatement();
			  System.out.println("done");
			  String q="insert into manager values('"+name+" ',"+id+", ' "+pnum+" ', '"+email+" ','"+m1+"' , '"+m2+"' , '"+m3+"' , '"+proj+"')";
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
