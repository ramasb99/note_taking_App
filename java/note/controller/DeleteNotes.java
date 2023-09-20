package note.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import note.Service.NoteServImp;
import note.Service.NoteService;

@WebServlet("/delnote")
public class DeleteNotes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	int nid=Integer.parseInt(request.getParameter("nid"));
	NoteService serv=new NoteServImp();
	boolean b=serv.delete(nid);
	if(b)
	{
		out.println("<script>alert('Delete Note Successfully')</script>");
		RequestDispatcher r=request.getRequestDispatcher("home");
		r.forward(request, response);
	}
	else
	{
		out.println("<script>alert('No delete note')</script>");
		RequestDispatcher r=request.getRequestDispatcher("home");
		r.forward(request, response);
	}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
