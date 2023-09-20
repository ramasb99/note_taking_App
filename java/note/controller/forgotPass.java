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

@WebServlet("/forpass")
public class forgotPass extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		out.println(email);

		User u=new User();
		u.setEmail(email);
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Forgot Password</title>"
				+ "  <link rel='stylesheet' href='css/index.css'>"
				+ "</head>"
				+ "<body>"
				+ "<form action='' method='post'>"
				+ "    <div class='main4'>"
				+ "     <div class='text3'><input type='password' name='pass' placeholder='New Password' required></div>"
				+ "    <div class='text3'><input type='password' name='confirm' placeholder='Confirm Password' required></div>"
				+ "    <div class='control3'><input type='submit' name='sub' value='Submit'></div>"
				+ "    <div class='btn3'><a href='login.html'>Click To Login</a>"
				+ "    </div>");
					
		           String b=request.getParameter("sub");
		           if(b!=null)
		           {
		        	   int pass=Integer.parseInt(request.getParameter("pass"));
						int cpass=Integer.parseInt(request.getParameter("confirm"));
						if(pass==cpass)
						{
							u.setEmail(email);
							u.setPassword(Integer.toString(pass));
							UserService serv=new UserServImp();
							boolean b1=serv.forgotPass(u);
							if(b1)
							{
								RequestDispatcher r=request.getRequestDispatcher("login.html");
								r.forward(request, response);
								out.println("<p><h3 style='color:green !important;'>Congratulation !...</h3><br><a style='text-decoration:none; padding:10px; color:white; background-color:red;' href='login.html'>Click Here for forgot password</a></p>");
						
							}
							else
							{
								RequestDispatcher r=request.getRequestDispatcher("VerifyEmail.html");
								r.include(request, response);
								out.println("<p><h1 style=' color:red;'>Something Isuue ! Process Again</h1><br></p>");
							}
						}
						else
						{
							RequestDispatcher r=request.getRequestDispatcher("forpass");
							r.include(request, response);
							out.println("<p><h1 style='color:red;'>Wrong Password</h1><br></p>");
						}
		           }
				out.println("</form></body></html>");

}
}


