package note.Repository;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;

import DBConfig.DBConn;
import note.Model.Category;

public class CategoryRepoImp extends DBConn implements CategoryRepo {

	@Override
	public boolean addCategory(Category c,int id) {
		try
		{
			cb=(CallableStatement) con.prepareCall("{call storeData('0',?,?)}");
			cb.setString(1,c.getName());
			cb.setInt(2, id);
			boolean b=cb.execute();
			if(!b)
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
			System.out.println("Category Add issue "+e);
		}
	
		return true;
		
	}

	
	List<Category> list=new ArrayList<Category>();
	@Override
	public List<Category> getCategory(int id) {
		try
		{
			ps=con.prepareStatement("select * from category where uid=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Category c=new Category();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				list.add(c);
			}
			return list.size()>0?list:null;
		}
		catch(Exception e)
		{
			System.out.println("View Category Error "+e);
			return null;
		}
		
	}
	@Override
	public List<Category> getCategoryByName(String name,int uid) {
		try
		{
			st=con.createStatement();
			rs=st.executeQuery("select * from category where cname LIKE '%"+name+"%' and uid='"+uid+"'");
			while(rs.next())
			{
				Category mod=new Category();
				mod.setName(rs.getString(2));
				list.add(mod);
			}
			return list.size()>0?list:null;
		}
		catch(Exception e)
		{
			System.out.println("Error of List Category shown "+e);
			return null;
		}
	}
	@Override
	public boolean getCatName(String name,int id) {
		try
		{
			ps=con.prepareStatement("select cname from category where cname=? and uid=?");
			ps.setString(1, name);
			ps.setInt(2, id);
		    rs=ps.executeQuery();
			if(rs.next())
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
			System.out.println("Category name Exists Error "+e);
			return false;
		}
	}
	@Override
	public String getCategoryUp(int cid, int id) {
		try
		{
			ps=con.prepareStatement("select * from category where cid=? and uid=?");
			ps.setInt(1, cid);
			ps.setInt(2, id);
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
			System.out.println("Category name Exists Error "+e);
			return null;
		}
	}
	@Override
	public boolean updateCat(Category c, int uid) {
		try
		{
			ps=con.prepareStatement("update category set cname=? where cid=? and uid=?");
			ps.setString(1, c.getName());
			ps.setInt(2, c.getId());
			ps.setInt(3, uid);
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
			System.out.println("Category Update Error "+e);
			return false;
		}
	}

}
