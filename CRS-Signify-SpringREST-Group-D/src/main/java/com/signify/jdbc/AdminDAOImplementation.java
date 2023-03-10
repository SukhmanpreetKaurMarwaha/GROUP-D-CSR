
/**
 * 
 */
package com.signify.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.constants.SQLConstants;
import com.signify.exception.AdminExceptions;
import com.signify.exception.StudentDBViewException;
import com.signify.utils.DBUtils;

/**
 * @author ALRAHIMA
 *
 */
public class AdminDAOImplementation implements AdminDAOInteface {
	
			   //Function to create admin database.
			   //admin ID, admin name,admin designation are passed here.
	     Connection conn=null;
	public boolean admin_db_create(int adminId ,String adminName,String AdminDesignation)
	{
		conn=DBUtils.getConnection();
		  // Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean value=false;
		   try{
			
			   
			  // Class.forName("com.mysql.cj.jdbc.Driver");

			   
			      //conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      stmt = conn.prepareStatement(SQLConstants.ADMIN_DB_CREATE);
			   
			      stmt.setInt(1, adminId); 
			      stmt.setString(2,adminName);
			      stmt.setString(3, AdminDesignation);
			      int row=stmt.executeUpdate();
			      if(row==0)
			    	  value=false;
			    	  
			      else
			    	  value = true;
			      
			   }
		   catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
		
	
		return value;
	}
	//Function to approve student registration.
	//student id and status paarameters are passed here.
	public boolean approvestd(int stdid, String status) //throws StudentDBViewException
	{
		conn=DBUtils.getConnection();
		
		//Connection conn = null;
		boolean value=false;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			      stmt = conn.prepareStatement(SQLConstants.APPROVE_STD_SEARCH);
			      stmt.setInt(1, stdid); 
			      ResultSet rs = stmt.executeQuery();
			      rs.next();
			     String stat= rs.getString("status");
			   //using equals function to approve students.
			    	if(stat.equals("yet_to_approve"))
			    	{
			    		 
			    		 stmt = conn.prepareStatement(SQLConstants.UPDATE_STD_APPROVE);
			    		 
					      stmt.setString(1,status);
					      stmt.setInt(2, stdid);
					      int row=stmt.executeUpdate();
					      if(row==0)
					    	  value=false;
					    	  
					      else
					    	  value = true;
					     
			    	}
			    	else {
			    		value=false;
			    	}

			      //stmt.close();
			      //conn.close();
			   } catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				   }
		  
		   return value;
		
	}

}