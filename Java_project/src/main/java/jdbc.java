
import java.sql.*;

public class jdbc {
	public static void main(String arg[])
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost/ organization","root","root");
			  System.out.println("Connection Established....");
			  Statement s= c.createStatement();
			  //s.execute("create table try(id int,name varchar(20))");
			  System.out.println("done");
		}
		catch(Exception e)
		{
			  System.out.println(e);
		}
	}

}
