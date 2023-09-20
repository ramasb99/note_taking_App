package note.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import note.Model.User;
import note.Service.UserServImp;
import note.Service.UserService;

@WebServlet("/verify")
public class verifyEmail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String but=request.getParameter("s");
		if(but!=null)
		{
			String email=request.getParameter("email");
			User u=new User();
			u.setEmail(email);
			UserService serv=new UserServImp();
			boolean b=serv.verifyEmail(u);
			if(b)
			{
				RequestDispatcher r=request.getRequestDispatcher("forpass");
				r.forward(request, response);
//				r.include(request, response);
//				out.println("<p><h3 style='color:green !important;'>Verified Complated</h3><br><a style='text-decoration:none; padding:10px; color:white; background-color:red;' href='forpass?email="+email+"'>Click Here for forgot password</a></p>");
			}
			else
			{
				RequestDispatcher r=request.getRequestDispatcher("VerifyEmail.html");
				r.include(request, response);
				out.println("<p><h1 style=' color:red;'>Wrong Email</h1><br></p>");
			}
		}
	}

}
