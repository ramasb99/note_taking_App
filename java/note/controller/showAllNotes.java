package note.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import note.Model.Note;
import note.Model.User;
import note.Service.NoteServImp;
import note.Service.NoteService;

@WebServlet("/showall")
public class showAllNotes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("id");	
		int id=Integer.parseInt(obj.toString());
	      
		List<Note>list=new ArrayList<Note>();
		
		User user=new User();
		user.setId(id);
		
		 NoteService Nserv=new NoteServImp();
	       list=Nserv.getNotes(id);
	       if(list.size()>0)
	       { 
	       for(Note n:list)
	       {
	    	   int cid=n.getCatid();
	    	   String catname= Nserv.getCatName(cid);
	       out.println(" <html><head><title></title>"
	       		+ " <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>"
	       		+ "</head>"
	       		+ "<body>"
	       		+ "<div class='container'>"
	       		+ "        <div class='row'>"
	       		+ "            <div class='col-md-3'>"
	       		+ "                <div class='card' >"
	       		+ "                <div class='card-body'>"
	       		+ "                  <h5 class='card-title'>"+catname+"</h5>"
	       		+ "                  <h6 class='card-subtitle mb-2 text-muted'>"+n.getTitle()+"</h6>"
	       		+ "                  <p class='card-text'>"+n.getDes()+"</p><hr>"
	       		+ "                   <span>Time&nbsp;:"+n.getDate()+"</span><br><br>"
	       		+ "                  <div><a href='' style='background-color: aqua; padding: 10px; border-radius: 10px; text-decoration: none;'>Edit</a>&nbsp;&nbsp;<a href='delnote?nid="+n.getId()+"'  style='background-color: aqua; padding: 10px; border-radius: 10px; text-decoration: none;'>Delete</a></div>"
	       		+ "                  <div>"
	       		+ "                  </div>"
	       		+ "                </div>"
	       		+ "              </div>"
	       		+ "            </div>"
	       		+ "        </div>"
	       		+ "    </div></body></html>");
	          }
	       }
	       else
	       {
	    	   RequestDispatcher r=request.getRequestDispatcher("home");
	    	   r.forward(request, response);
	       }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
