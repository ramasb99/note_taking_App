package note.Repository;

import java.sql.SQLException;

import DBConfig.DBConn;
import note.Model.User;

public class UserRepoImp extends DBConn implements UserRepo {

	@Override
	public User regUser(User user) {
		
		try {
			ps=con.prepareStatement("insert into user1 values('0',?,?,?,?)");
			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getContact());
			ps.setString(4, user.getPassword());
		    int val=ps.executeUpdate();
			if(val!=0)
			{
				return user;
			}
			else
			{
				return null;
			}
		} 
		catch (Exception e) {
			System.out.println("Registration Error "+e);
			return null;
		}		
	}

	@Override
	public User isValid(User user) {
		try
		{
			ps=con.prepareStatement("select * from user1 where email=? and password=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			if(rs.next())
			{
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(3));
				return user;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Login Error is "+e);
			return null;
		}
		
	}

	@Override
	public String getNameById(User user) {
		try
		{
		     ps=con.prepareStatement("select * from user1 where uid=?");
		     ps.setInt(1, user.getId());
		     rs=ps.executeQuery();
		     if(rs.next())
		     {
		    	user.setUname(rs.getString(2));
		    	String name=user.getUname();
		    	return name;
		     }
		     
		}
		catch(Exception e)
		{
			System.out.println("GetName Error "+e);
		}
		return null;
	}

	@Override
	public boolean verifyEmail(User u) {
		try
		{
			ps=con.prepareStatement("select email from user1 where email=?");
		    ps.setString(1, u.getEmail());
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
			System.out.println("Email varification Mail "+e);
			return false;
		}
		
	}

	@Override
	public boolean forgotPass(User u) {
		try
		{
			ps=con.prepareStatement("update user1 set password=? where email=?");
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getEmail());
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
			System.out.println("Forgot Password Error "+e);
			return false;
		}
	
	}

	@Override
	public User getDataById(User u) {
		try
		{
			ps=con.prepareStatement("select * from user1 where uid=?");
			ps.setInt(1, u.getId());
			rs=ps.executeQuery();
			if(rs.next())
			{
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setContact(rs.getString(4));
				return u;
			}
			else
			{
				return null;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("User Data Error "+e);
			return null;
		}
		
	}

	@Override
	public boolean UpdateUser(User u) {
		try
		{
			ps=con.prepareStatement("update user1 set name=?,contact=? where uid=?");
			ps.setString(1, u.getUname());
			ps.setString(2, u.getContact());
			ps.setInt(3, u.getId());
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
			System.out.println("Update User Error "+e);
			return false;
		}
	}

	@Override
	public boolean UpdateEmail(User u) {
		try
		{
			ps=con.prepareStatement("update user1 set email=? where uid=?");
		    ps.setString(1, u.getEmail());
		    ps.setInt(2, u.getId() );
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
			System.out.println("Email varification Mail "+e);
			return false;
		}
	}

}
