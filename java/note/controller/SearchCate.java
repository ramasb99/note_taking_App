package note.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import note.Model.Category;
import note.Service.CategoryServImp;
import note.Service.CategoryService;


@WebServlet("/search")
public class SearchCate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
			
		String name=request.getParameter("catName");
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("id");
		CategoryService serv=new CategoryServImp();
		List <Category> list=serv.getCategoryByName(name,uid);
		out.println("<html>"
				+ "<head>"
				+ "<link rel='stylesheet' href='css/category.css'>"
				+ "</head>"
				+ "<body>"
				+ "<div class='tab'>"
				+ "<table>"
				+ " <tr><th>CATEGORY</th><th>DELETE</th><th>DISABLE</th></tr>");
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
				+ "</body>"
				+ "</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
