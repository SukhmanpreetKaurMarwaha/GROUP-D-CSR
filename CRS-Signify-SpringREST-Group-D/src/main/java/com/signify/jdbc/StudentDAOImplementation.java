/**
 * 
 */
package com.signify.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Student;
import com.signify.constants.SQLConstants;
import com.signify.exception.AdminExceptions;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.UpdatePasswordException;
import com.signify.exception.ViewUnapprovedStudentsException;
import com.signify.utils.DBUtils;

/**
 * @author ALRAHIMA
 *
 */
public class StudentDAOImplementation implements StudentDAOInterface {
	
			    Connection conn=null;
	//Function to create student database.
	//student ID,name,branch,batch and status are the parameters passed here.
	public boolean student_db_create(int studentId, String name, String branch, String batch, String status )
	{
		// Step 2 
		// Declare the Connection or prepaid statement variable here 
		conn=DBUtils.getConnection();
		//   Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean value=false;
		   try{
			   
			  
			    
			      stmt = conn.prepareStatement(SQLConstants.REGISTER_STUDENT);
			   
			 
			      //Bind values into the parameters.
			      stmt.setInt(1, studentId);  // This would set age
			      stmt.setString(2,name);
			      stmt.setString(3, branch);
			      stmt.setString(4,batch);
			      stmt.setString(5,status);
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
	}
	//Function to view student database.
	public List<Student> student_db_view() //throws StudentDBViewException
	{
		conn=DBUtils.getConnection();
		 //Connection conn = null;
		   PreparedStatement stmt = null;
		   
		
		   List<Student> student= new ArrayList<>();
	
		   
		   try{
		
			     
		stmt = conn.prepareStatement(SQLConstants.STUDENT_DB_VIEW);
		
	      ResultSet rs = stmt.executeQuery();
	      while(rs.next()) {
	    	  Student students=new Student();
	    	  students.setBatch(rs.getString("Batch"));
	    	  students.setBranch(rs.getString("Branch"));
	    	  students.setStudentid(rs.getInt("studentid"));
	    	  students.setStudent_name( rs.getString("Student_name"));
	    	  student.add(students);
	      }

	   
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
		   //throw new StudentDBViewException();
			 
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }

		   return student;
	
	}
	
	//Function to update the password.
	//user Id, new password and old password are the parameters passed here.
	public boolean update_pass(int id, String newpass, String oldpass) //throws UpdatePasswordException
	{
		conn=DBUtils.getConnection();
		//Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean value=false;
		   try{
			   
			 
			      stmt = conn.prepareStatement(SQLConstants.SEARCH_PASS);
			      stmt.setInt(1, id); 
			      ResultSet rs = stmt.executeQuery();
			      rs.next();
			     String pwd= rs.getString("Password");
			   
			    	if(pwd.equals(oldpass))
			    	{
			    		 
			    		 stmt = conn.prepareStatement(SQLConstants.UPDATE_PASS);
			    	
					      stmt.setString(1,newpass);
					      stmt.setInt(2, id);
					     
					      int row=stmt.executeUpdate();
					      if(row==0)
					    	 value=false;
					    	  
					      else
					    	  value = true;
			    	}
			    	else {
			    		value=false;
			    	}
			     
			      

			   }catch(SQLException  se){
			   //throw new UpdatePasswordException();
				   se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		   return value;
	}
	//Function to view unapproved students.
	public List<Student> view_unapproved_stds() //throws ViewUnapprovedStudentsException
	{
		conn=DBUtils.getConnection();
		// Connection conn = null;
		   PreparedStatement stmt = null;
		   List<Student> student=new ArrayList<>();
		   
		   try{
			
		
		stmt = conn.prepareStatement(SQLConstants.VIEW_UNAPPROVED_STUDENTS);
		 // stmt.setInt(1, studentId);
	      ResultSet rs = stmt.executeQuery();
	      //rs.next();

	      while(rs.next())
		     {
		    	 Student students=new Student();
		    	
		    	 students.setBatch(rs.getString("Batch"));
		    	 students.setBranch(rs.getString("Branch"));;
		    	 students.setStudent_name(rs.getString("Student_name"));;
		    	 students.setStudentid( rs.getInt("studentid"));
		    	 students.setPassword("cannot disclose");
		    	
		    	 student.add(students);
		    	 
		     }
	
	   }catch(SQLException se){
		  // throw new ViewUnapprovedStudentsException();
		   se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }

		   return student;
	}
	//Function for student login.
	//student ID, username and password are the parameters passed here.
	public boolean std_login(int id,String userpass,String username)
	{
		conn=DBUtils.getConnection();
		//Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean flag=false;
		   
		   try{
			   
			  
			  
			      stmt = conn.prepareStatement(SQLConstants.STUDENT_LOGIN_SEARCH);
					 stmt.setInt(1, id);
				      ResultSet rs = stmt.executeQuery();
				      rs.next();
				      String status=rs.getString("status");
				      if(status.equals("approved"))
				      {
			      stmt = conn.prepareStatement(SQLConstants.STUDENT_LOGIN);
			      stmt.setLong(1,id);
			      stmt.setString(2,userpass);
			  
			      ResultSet rs1 = stmt.executeQuery();
			      rs1.next();
			      String name1 = rs1.getString("User_name");
			 
			      if(name1.equals(username) )
			      {
			    	  flag =true;
			    	
			      }
			      else 
			      {
			    	  flag =false;
			    	 
			      }}
				      else {
				    	
				    	  flag=false;
				      }

			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

			   return flag;
		
	}
	}

