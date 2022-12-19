package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBUtil.DBUtility;
import Exception.BdoException;
import Model.BDO;

public class AdminImpl  implements AdminDao{

	 

	@Override
	public String addBdo(BDO b) throws BdoException {
	String message = "Wrong Credentials";
			
			try(Connection conn = DBUtility.getConnection()) {
	   PreparedStatement ps = conn.prepareStatement("insert into bdo(name, username, password) values(?,?,?)");	
	   ps.setString(1, b.getName());
	   ps.setString(2, b.getUsername());
	   ps.setString(3, b.getPassword());
	   
			   int x = ps.executeUpdate();
			   if (x > 0)
					message = "Inserted Successfully";
		 	
			} catch (SQLException e) {
			  e.printStackTrace();
			  message = e.getMessage();
			}
			 
			return message;
	}

}
