

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

import com.signify.bean.Student;
import com.signify.constants.SQLConstants;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.ViewEnrolledStudentsException;
import com.signify.utils.DBUtils;

/**
 * @author ALRAHIMA
 *
 */

public class ProfessorDAOImplementation implements ProfessorDAOInterface {
	
			  Connection conn=null;
		//Function to create the professor database.
			   //professor ID,name,designation and date of joining are the parameters passed here.
	public boolean professor_db_create(int proffId, String name,String designation,String doj)
	{
		// Step 2 
		// Declare the Connection or prepaid statement variable here 
		conn=DBUtils.getConnection();
		   //Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean value=false;
		   
		   try{
			   
			      
			    
			      stmt = conn.prepareStatement(SQLConstants.PROFESSOR_DB_CREATE);
			   
			 
			      //Bind values into the parameters.
			      stmt.setInt(1, proffId);  // This would set age
			      stmt.setString(2, name);
			      stmt.setString(3,designation);
			      stmt.setString(4, doj);
			      
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
	//Function to add grade for each student.
	//student ID,course ID,grade and professor ID are the parameters passed here.
	public boolean addGrade(int studentid,String courseid,String grade,int profid) {
		conn=DBUtils.getConnection();
		//Connection conn = null;]
		boolean value=false;
		boolean ans =false;
		   PreparedStatement stmt = null;
		   
		   try{
			 
			   stmt = conn.prepareStatement(SQLConstants.SEARCH_STUDENT_WITH_COURSE);
			   stmt.setInt(1,studentid );
			     ResultSet rs1 = stmt.executeQuery();
			    
			      //rs1.next();
			    while(rs1.next())
			    {
			    	System.out.println("hello");
			    	 String courseid1= rs1.getString("courseid");
			    	if(courseid1.equals(courseid))
			    	{
			    		System.out.println("out");
			    		ans=true;
			    	}
			    }
			     
			    if(ans ==true) {
			      stmt = conn.prepareStatement(SQLConstants.ADD_GRADE);
			   
			 
			      //Bind values into the parameters.
			      stmt.setInt(1, studentid);  // This would set age
			      stmt.setInt(2,profid);
			      stmt.setString(3, courseid);
			      stmt.setString(4,grade);
			      //stmt.setString(5, doj);
			      int row=stmt.executeUpdate();
			      if(row==0)
			    	  value=false;
			    	  
			      else
			    	  value = true;   
			   
			    }

			   }catch(SQLException se){
				   se.printStackTrace();
				  // throw new StudentDBViewException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		
		return value ;
		
	}
	//Function to view enrolled students.
	//professor ID is the parameter passed here.
	public List<Student> viewEnrolledStudents(int pid) {//throws ViewEnrolledStudentsException{
		conn=DBUtils.getConnection();
		//Connection conn = null;
		   PreparedStatement stmt = null;
		   List<Student> student=new ArrayList<>();
		   try{
			  
			    
			      stmt = conn.prepareStatement(SQLConstants.SEARCH_COURSE_INFO_viewEnrolledStudents);
			      stmt.setInt(1, pid);
			      ResultSet rs = stmt.executeQuery();
			      rs.next();
			     String courseid= rs.getString("courseid");
			
			     stmt = conn.prepareStatement(SQLConstants.SEARCH_STUDENTID_viewEnrolledStudents);
			      stmt.setString(1,courseid );
			      ResultSet rs1 = stmt.executeQuery();
			      
			      
			    while(rs1.next()) {
			     int id = rs1.getInt("studentid");
			     
			     stmt = conn.prepareStatement(SQLConstants.VIEW_ENROLLED_STUDENTS);
			      stmt.setInt(1,id );
			      
			      ResultSet rs2 = stmt.executeQuery();
			      
			      while(rs2.next())
			      {
			    	  Student students= new Student();
			    	  students.setBatch(rs2.getString("Batch"));
			    	  students.setBranch(rs2.getString("Branch"));
			    	  students.setStudent_name(rs2.getString("Student_name"));
			    	  students.setStudentid(rs2.getInt("studentid"));
			    	  student.add(students);
			      }
			    }
			  
			   }catch(SQLException se){
				   se.printStackTrace();
				  //throw new ViewEnrolledStudentsException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		
		return student;
	}

}