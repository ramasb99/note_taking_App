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

@WebServlet("/userup")
public class UpdateUser extends HttpServlet {
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
			out.println("<form action='' method='post'>"
					+ "    <div class='main'>"
					+ "    <div class='h'><h1>Update User</h1></div>"
					+ "    <div class='text'><input type='text' name='name' value='"+user.getUname()+"'></div>"
					+ "    <div class='text'><input type='text' name='contact' value='"+user.getContact()+"'></div>"
					+ "    <div class='control'><input type='submit' name='update' value='Update'></div>"
					+ "    </div>");
			    String name=request.getParameter("name");
			    String cont=request.getParameter("contact");
			    String but=request.getParameter("update");
			    if(but!=null)
			    {
			    	user.setUname(name);
			    	user.setContact(cont);
			        boolean b=serv.UpdateUser(user);
			        if(b)
			        {   out.println("<script>alert('Updated Success')</script>");
			        try {
						Thread.sleep(5000);
						r=request.getRequestDispatcher("udetail");
		         	   r.forward(request, response);

					} 
			        catch (InterruptedException e) {
						e.printStackTrace();
					}
			           }
			        else
			        {
			        	out.println("<script>alert('Something Wrong')</script>");
			        }
			    }
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
