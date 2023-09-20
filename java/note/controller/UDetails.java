package note.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import note.Model.User;
import note.Service.UserServImp;
import note.Service.UserService;

@WebServlet("/udetail")
public class UDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session =request.getSession();
		int id=(int)session.getAttribute("id");
		User u=new User();
		u.setId(id);
		RequestDispatcher r=request.getRequestDispatcher("UserNav.html");
		r.include(request, response);
	   
	    	UserService serv=new UserServImp();
	  	    User user=serv.getDetailsById(u);
	  	    out.println("<br><br>");
			out.println("<html>");
	 		out.println("<head>");
			out.println("<title>UserDetails</title>");
			out.println("<link rel='stylesheet' href='css/UserDetails.css'>");
			out.println("</head>");
			out.print( "<body>");
			out.println("<div class='main2'>");
			out.println("<div class='text1'><h1>My Details</h1></div>");
			out.println("<div class='text1'><input type='text' name='name' value='"+user.getUname()+"' ></div>");
			out.println("<div class='text1'><input type='email' name='email' value='"+user.getEmail()+"' ></div>");
			out.println("<div class='text1'><input type='text' name='contact' value='"+user.getContact()+"'></div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
	    
	    	  
		
		    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
