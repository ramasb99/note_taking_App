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


@WebServlet("/uemail")
public class UpdateEmail extends HttpServlet {
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
			out.println("<form action='' method='post'>"
					+ "    <div class='main'>"
					+ "    <div class='h'><h1>Update Email</h1></div>"
					+ "    <div class='text'><input type='text' name='email' value='"+user.getEmail()+"' placeholder='Enter Email'></div><br><br>"
					+ "    <div class='control'><input type='submit' name='up' value='Update'></div>");
			out.println("</div></form>");
			out.println("</body>");
			out.println("</html>");
			 String btn=request.getParameter("up");
             if(btn!=null)
             {
          	   String email=request.getParameter("email");
          	   user.setEmail(email);
               user.setId(id);
          	   boolean b=serv.UpdateEmail(user);
          	   if(b)
          	   {
          		 out.println("<script>alert('Update Email')</script>");
          		 try {
					Thread.sleep(5000);
					r=request.getRequestDispatcher("udetail");
	         	   r.forward(request, response);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
       		}
          	   else
          	   {
          		   System.out.println("Invalid Isuue");
          	   }          	   
             }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
