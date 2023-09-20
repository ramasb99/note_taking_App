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

import note.Model.User;
import note.Service.UserServImp;
import note.Service.UserService;

@WebServlet("/reg")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String password=request.getParameter("pass");
			
			User u=new User();
			u.setUname(name);
			u.setEmail(email);
			u.setContact(contact);
			u.setPassword(password);
			
			UserService serv=new UserServImp();
			User user=serv.regUser(u);
			if(user!=null)
			{
				RequestDispatcher r=request.getRequestDispatcher("registration.html");
				r.include(request, response);
				out.println("<h1 style='color:red;'>Registration Successfully ! click on Login</h1>");
			}
			else
			{
				out.println("<h1>Somthing Wrong</h1>");
			}
			
		}
		else
		{
			
		}
		
	}

}
