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
public class UserDAOImplementation implements UserDAOInterface {
	
		    Connection conn=null;
		   
		   public boolean create_user(int id,String pass,String name,String role)
		   {
			
			   conn=DBUtils.getConnection();
				  // Connection conn = null;
				   PreparedStatement stmt = null;
				   boolean value=false;
				   try{
					   
					 
					      
					      stmt = conn.prepareStatement(SQLConstants.CREATE_USER);
					   
					 
					      //Bind values into the parameters.
					      stmt.setInt(1, id);  // This would set age
					      stmt.setString(2, name);
					      stmt.setString(3, pass);
					      stmt.setString(4, role);
					      
					      int row=stmt.executeUpdate();
					      if(row==0)
					    	 value=false;
					    	  
					      else
					    	  value = true;
					       

					   }catch(SQLException se){
					      //Handle errors for JDBC
					      se.printStackTrace();
						   
					   }catch(Exception e){
					      //Handle errors for Class.forName
					      e.printStackTrace();
					   }

			   
			   return value;
			   //return false;
		   }
		   public boolean login(int userid1, String pwd, String name,String Role1) //throws StudentDBViewException
			{
			   conn=DBUtils.getConnection();
			   //Connection conn = null;
			   PreparedStatement stmt = null;
			   boolean flag=false;
			   
			   try{
				
				      stmt = conn.prepareStatement(SQLConstants.LOGIN);
				      stmt.setLong(1,userid1);
				      stmt.setString(2,pwd);
				  
				      ResultSet rs = stmt.executeQuery();
				      rs.next();
				      String name1 = rs.getString("User_name");
				      String role = rs.getString("Role");
				      if(name1.equals(name) && role.equals(Role1) )
				      {
				    	  flag =true;
				    	  //System.out.println("xxx");
				      }
				      else 
				      {
				    	  flag =false;
				    	  //System.out.println("yyy");
				      }

				   }catch(SQLException se){
				    // throw new StudentDBViewException();
					   se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				   }

				  
				   return flag;
				}
				  

}