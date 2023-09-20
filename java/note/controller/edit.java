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
import note.Model.Note;
import note.Service.CategoryServImp;
import note.Service.CategoryService;
import note.Service.NoteServImp;
import note.Service.NoteService;

@WebServlet("/edit")
public class edit extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("id");
		
		int nid=(int)Integer.parseInt(request.getParameter("nid"));
		
		CategoryService catserv=new CategoryServImp();
		
		List<Category> list=catserv.getCategory(uid);
		NoteService Nserv=new NoteServImp();
		Note n=Nserv.getData(nid);
		out.println("<br><br><html>"
				+ "<head>"
				+ "    <link rel='stylesheet' href='css/note.css'>"
				+ "</head>"
				+ "<body>"
				+ "    <div class='main'>"
				+ "        <form action='' method='POST'>"
				+ "         <div class='title'><input type='text' name='title' value='"+n.getTitle()+"' placeholder='Enter Title'></div>"
				+ "         <div class='tex'><textarea name='des' id='' value='"+n.getDes()+"' placeholder='To prevent a text field from being resized, you can use the CSS resize property with its value.'></textarea></div>"
				+ "         <div class='sel'><select name='op' value=''><option>--Select One--</option>");
			      for(Category c:list)
			      {
			    	  out.println("<option value='"+c.getId()+"'>"+c.getName()+"</option>");
			      }
			      out.println("</select></div>"
				+ "         <div class='btn'><input type='submit' value='Add Note' name='ad'></div>"
				+ "         <div class='btn'><a"
				+ "             href='home'>Back To Home</a></div>"
				+ "        </form>"
				+ "    </div>"
				+ "</body>"
				+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
