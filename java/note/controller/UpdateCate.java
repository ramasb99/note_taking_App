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

import note.Model.Category;
import note.Model.User;
import note.Service.CategoryServImp;
import note.Service.CategoryService;


@WebServlet("/update")
public class UpdateCate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int catid=Integer.parseInt(request.getParameter("cid"));
		HttpSession session=request.getSession();
		int uid=(int) session.getAttribute("id");
		
		User u=new User();
		u.setId(uid);
		
		Category cat=new Category();
		cat.setId(catid);
		CategoryService serv=new CategoryServImp();
		String name=serv.getCategoryUp(catid, uid);
		cat.setName(name);
		RequestDispatcher r=request.getRequestDispatcher("category.html");
        r.include(request, response);
		out.println("<br><br><br><html>"
				+ "<head>"
				+ "<title>Category</title>"
				+ "<link rel='stylesheet' href='css/category.css'>"
				+ "</head>");
	    out.println("<body>"
				+ "    <div class='cen'>"
				+ "    <form action='' method='POST'>"
				+ "      <div><input class='input' type='text' name='catname' value='"+cat.getName()+"' ></div><br><br><br>"
				+ "      <div><input class='btn' type='submit' name='upd' value='Update Category'></div>"
				+ "    </form>"
				+ "</div>");
	     out.println("</body></html>");
	     String s=request.getParameter("upd");
	     
	     if(s!=null)
	     {	    
	    		String ctnam=request.getParameter("catname");
//	    		System.gc();
	    		u.setId(uid);
	    		cat.setId(catid);
	    		cat.setName(ctnam);
	    		boolean b=serv.updateCat(cat, u.getId());
	    		if(b)
	    		{
	    			out.println("<script>alert('Updated Success')</script>");
	    			r=request.getRequestDispatcher("viewc");
	    			r.forward(request, response);
	    		}
	    		else
	    		{
	    			out.println("<script>alert('Something Wrong')</script>");
	    		}
	    		
	     }

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
