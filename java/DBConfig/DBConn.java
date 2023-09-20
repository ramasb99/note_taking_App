package DBConfig;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

public class DBConn {
	protected Connection con;
	protected ResultSet rs;
	protected Statement st;
	protected PreparedStatement ps;
	protected CallableStatement cb;

	public DBConn() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notetake","root","");
			if(con!=null)
			{
				System.out.println("Connected");
			}
			else
			{
				System.out.println("Something Wrong Not Connected");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Connection Error"+ex);
		}
		
	}

}
