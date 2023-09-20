package note.Repository;

import java.util.ArrayList;
import java.util.List;

import DBConfig.DBConn;
import note.Model.Note;

public class NoteRepoImp extends DBConn  implements NoteRepo{

	@Override
	public boolean AddNote(Note n) {
		try
		{
			ps=con.prepareStatement("insert into notes(nid,title,discription,cid,uid) values('0',?,?,?,?)");
			ps.setString(1, n.getTitle());
			ps.setString(2, n.getDes());
			ps.setInt(3, n.getCatid());
			ps.setInt(4, n.getUserid());
			int val=ps.executeUpdate();
			if(val>0)
			{
				return true;
			}
			else
			{
				
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Add notes in "+e);
			return false;
		}
	}

	List <Note>list=new ArrayList<Note>();
	@Override
	public List<Note> getNotes(int id) {
		try 
		{
			ps=con.prepareStatement("select * from notes where uid=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Note n=new Note();
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setDes(rs.getString(3));
				n.setCatid(rs.getInt(4));
				n.setDate(rs.getString(6));
				list.add(n);
			}
			return list.size()>0?list:null;
			
		}
		catch(Exception e)
		{
			System.out.println("Get Notes Data"+e);
			return null;
		}
		
	}
	@Override
	public String getCatName(int id) {
		try 
		{
			ps=con.prepareStatement("select * from category where cid=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				String name=rs.getString(2);
				return name;
			}
			else
			{
				return null;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("GetCategory Name"+e);
			return null;
		}
	}
	@Override
	public boolean deleteNote(int id) {
	   try
	   {
		   ps=con.prepareStatement("delete from notes where nid=?");
		   ps.setInt(1, id);
		   int val=ps.executeUpdate();
		   if(val>0)
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
	   }
	   catch(Exception e)
	   {
		   System.out.println("Delete is "+e);
	   }
		return false;
	}
	@Override
	public Note getNote(int uid) {
		try
		{
			ps=con.prepareStatement("select * from notes where nid=?");
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				Note n=new Note();
				n.setId(rs.getInt(1));
				n.setDes(rs.getString(3));
				n.setTitle(rs.getString(2));
				n.setCatid(rs.getInt(4));
				return n;
				
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("get Notes Data "+e);
		}
		return null;
	}

}
