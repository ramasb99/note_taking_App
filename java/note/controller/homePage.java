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
import note.Service.UserServImp;
import note.Service.UserService;

@WebServlet("/home")
public class homePage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("id");	
		int id=Integer.parseInt(obj.toString());
	      
		List<Note>nlist=new ArrayList<Note>();
		User user=new User();
		user.setId(id);
		
		UserService serv = new UserServImp(); 
		String name=serv.getNameById(user);
		String s[]=name.split(" ");
		int i=0;
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Note Taking Application</title>"
				+ "<link rel='stylesheet' href='css/user.css'>"
				+ " <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>"
				+ "<script type='text/javascript' src='js/menuBar.js'></script>"
				+ "</head>"
				+ "<body>"
				+ "    <div class='heder'>"
				+ "        <div class='left'><logo><img src='img/edit.gif'></logo></div>"
				+ "        <div class='right'>"
				+ "            <div class='nav'>"
				+ "                <nav>"
				+ "                    <ul>"
				+ "                      <li class='nav-item'>"
				+ "                         <h4>Welcome &nbsp;"+s[i]+"</h4>"
				+ "                      </li>"
				+ "                      <li class='nav-item'>"
				+ "                        <a  href='logout'>Logout</a>"
				+ "                      </li>"
				+ "                    </ul>"
				+ "                </nav>"
				+ "            </div>"
				+ "            <div class='hname'><h1>AMAZING NOTES</h1></div>"
				+ "        </div>"
				+ "       </div>"
				+ "       <span class='ticon' onclick='showMenu()'>&#9776;</span>"
				+ "      <div class='menu'>"
				+ "        <span class='close' onclick='closeMenu()'>&times;</span>"
				+ "      <h2>"+name+"</h2>"
				+ "      <ul>"
				+ "        <li><a href='UserNav.html'>MY PROFILE </a></li>"
				+ "        <li><a href='category.html'>CATEGORY </a></li>"
				+ "        <li><a href='Notes.html'>NOTES </a></li>"
				+ "        <li><a href='showall'>Search CategoryWise </a></li>"
				
				+ "      </ul>"
				+ "    </div>");
		
		      NoteService Nserv=new NoteServImp();
		       nlist=Nserv.getNotes(id);
		       if(nlist.size()>0)
		       {
		        for(Note n:nlist)
		        {
		    	   int cid=n.getCatid();
		    	   String catname= Nserv.getCatName(cid);
		       out.println(" <div class='container'>"
		       		+ "        <div class='row'>"
		       		+ "            <div class='col-md-3'>"
		       		+ "                <div class='card' >"
		       		+ "                <div class='card-body'>"
		       		+ "                  <h5 class='card-title'>"+catname+"</h5>"
		       		+ "                  <h6 class='card-subtitle mb-2 text-muted'>"+n.getTitle()+"</h6>"
		       		+ "                  <p class='card-text'>"+n.getDes()+"</p><hr>"
		       		+ "                   <span>Time&nbsp;:"+n.getDate()+"</span><br><br>"
		       		+ "                  <div><a href='edit?nid="+n.getId()+"' style='background-color: aqua; padding: 10px; border-radius: 10px; text-decoration: none;'>Edit</a>&nbsp;&nbsp;<a href='delnote?nid="+n.getId()+"'  style='background-color: aqua; padding: 10px; border-radius: 10px; text-decoration: none;'>Delete</a></div>"
		       		+ "                  <div>"
		       		+ "                  </div>"
		       		+ "                </div>"
		       		+ "              </div>"
		       		+ "            </div>"
		       		+ "        </div>"
		       		+ "    </div>");
		          }
               	out.println("</body>"
				+ "</html>");
		       }
		       else
		       {
		    	   RequestDispatcher r=request.getRequestDispatcher("home");
		       }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
