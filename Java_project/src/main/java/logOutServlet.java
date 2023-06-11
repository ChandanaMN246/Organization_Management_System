

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logOutServlet
 */
@WebServlet("/logOutServlet")
public class logOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public logOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        Cookie ck=new Cookie("adminName",""); 
        ck.setMaxAge(0); response.addCookie(ck);
        out.print("<h1>you are successfully logged out!</h1>");
        request.getRequestDispatcher("index.html").include(request, response);
        }
}
