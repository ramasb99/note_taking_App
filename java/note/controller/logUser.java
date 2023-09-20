package note.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import note.Model.User;
import note.Service.UserServImp;
import note.Service.UserService;

@WebServlet("/log")
public class logUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
	     String email=request.getParameter("email");
	     String pass=request.getParameter("pass");
	     String but=request.getParameter("login");
	     User u=new User(); // model
	     u.setEmail(email);
	     u.setPassword(pass);
	     
	     UserService serv=new UserServImp();
	     User user=serv.isValid(u);
	     if(user!=null)
		     {
		    	 HttpSession session=request.getSession(true);
		    	 session.setAttribute("id",user.getId());
		    	 
		    	 Cookie c = new Cookie("u",email);
				 c.setMaxAge(60*1);//1 min
				 response.addCookie(c);
				 
				 Cookie c1 = new Cookie("p", pass);
				 c.setMaxAge(60*1);//1 min
				 response.addCookie(c1);
				 
		    	 RequestDispatcher r=request.getRequestDispatcher("home");
		    	 r.forward(request, response);
		     }
		     else
		     {
		    	 RequestDispatcher r=request.getRequestDispatcher("login.html");
					r.include(request, response);
					out.println("<script>alert('Invalid Username and Password')</script>");
		     }
	    }
	   
	  
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   doGet(request,response);
	}

}
