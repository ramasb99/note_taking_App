package note.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/addcat")
public class addCategory extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("id");
	    User u=new User();
		   
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
				+ "      <div><input class='input' type='text' name='cat' placeholder='Enter Category'></div><br><br><br>"
				+ "      <div><input class='btn' type='submit' name='s' value='Add Category'></div>"
				+ "    </form>"
				+ "</div>");
	     out.println("</body></html>");
	     String cate=request.getParameter("cat");
//	     out.println(cate);
    	 Category c=new Category();
//    	out.println(cat);
    	 u.setId(id);
	     String s=request.getParameter("s");
	     if(s!=null)
	     {	    	 
	    	CategoryService serv=new CategoryServImp();
	    	boolean flag=serv.getCatName(cate, u.getId());
	    	if(flag)
    		{
    			out.println("<script>alert('Category already exist')</script>");
    		}
    		else
    		{
    			serv=new CategoryServImp();
    			c.setName(cate);
    	    	 boolean b=serv.addCategory(c, u.getId());
    	    	 if(b)
    	    	 {
    	    		out.println("<script>alert('Category Added Success')</script>");
    	    	 }
    	    	 else
    	    	 {
    	    		 out.println("<script>alert('Category Failed')</script>");
    	    	 }
    		}
	     }
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
