package note.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import note.Model.Category;
import note.Service.CategoryServImp;
import note.Service.CategoryService;

@WebServlet("/viewc")
public class viewCate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		int id=(int)session.getAttribute("id");
				
		CategoryService serv=new CategoryServImp();
		List<Category>list=serv.getCategory(id);
		RequestDispatcher r=request.getRequestDispatcher("category.html");
		r.include(request, response);
//		if(list.size()>0)
//		{
			out.println("<html>"
					+ "<head>"
					+ "<link rel='stylesheet' href='css/category.css'>"
					+ "<script src='js/search.js' type='text/javascript'></script>"
					+ "</head>"
					+ "<body><br><br>"
					+ "<div align='center'><input type='text' name='cname' value='' placeholder='Search category here' onkeyup='searchCategory(this.value)' style='width:700px; float:left; margin-left:230px; height:40px; align:center;'/></div>"
					+ "<div id='d'>"
					+ "<div class='tab'>"
					+ "<table>"
					+ "<tr><th>CATEGORY</th><th>UPDATE</th><th>DISABLE</th></tr>");
					for(Category cat:list)
					{
			    		out.println("<tr>");
						out.println("<td>"+cat.getName()+"</td>");
						out.println("<td><a href='update?cid="+cat.getId()+"'>Update</a></td>");
						out.println("<td><a href=''>Disable</a></td>");
						out.println("<tr>");
					}
					out.println("</table>"
					+ "</div>"				
				    + "</div>"
					+ "</body>"
					+ "</html>");
//		}
//		else
//		{
//			out.println("<h1 style='margin-left:300px;font-size:26px;color:Red;'>NO Category Available</h1>");
//		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
