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
import com.signify.bean.Grade;
import com.signify.bean.Payment;
import com.signify.bean.Student;
import com.signify.constants.SQLConstants;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewGradeCardException;
import com.signify.utils.DBUtils;

/**
 * @author ALRAHIMA
 *
 */

public class CourseCatalogDAOImplementation implements CourseCatalogDAOInterface {
	// Step 1
	Payment pay;
		
	 Connection conn=null;
			   //Function catalog database create to create the catalog.
			   //course ID, course name,course professor,course price are the parameters passed here.
	public boolean catalog_db_create(String courseId, String courseName, int courseProf,int courseprice) 
	{
		conn=DBUtils.getConnection();
		// Step 2 
		// Declare the Connection or prepaid statement variable here 
		  //Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean value=false;
		   try{
			   
			   
			   
			      stmt = conn.prepareStatement(SQLConstants.ADD_COURSE_CATALOG);
	
			      stmt.setString(1, courseId);  // This would set age
			      stmt.setString(2,courseName);
			      stmt.setInt(3, courseProf);
			      stmt.setInt(4, courseprice);
			      int row=stmt.executeUpdate();
			      if(row==0)
			    	  value=false;
			    	  
			      else
			    	  value = true;
			      
			     

			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
				  // throw new CourseCreateExceptions();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		
		return value;
	}
	//Function to delete a course.
	//course ID is the parameter passed here.
	public boolean deleteCourse(String courseid1) throws DeleteCourseException {
		conn=DBUtils.getConnection();
		//Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean value=false;
		   try{
			
			  
			      stmt = conn.prepareStatement(SQLConstants.DELETE_COURSE_CATALOG);
			      stmt.setString(1, courseid1);  // This would set age
			      int row=stmt.executeUpdate();
			     if(row==0)
			      value=false;
			     else
			    	 value=true;
			      
//			    stmt.close();
//			      conn.close();
			   }catch(SQLException  se){
			 
				   throw new DeleteCourseException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		return value;
		
	}
	//Function to view the course details.
	//course ID is the parameter passed here.
	public List<Course> CourseDetail() //throws CourseDetailsException
	{
		conn=DBUtils.getConnection();
		// Connection conn = null;
		   PreparedStatement stmt = null;
		   List<Course> course=new ArrayList<>();
		   
		   try{
			 
		stmt = conn.prepareStatement(SQLConstants.COURSE_DETAILS);
		
	       ResultSet rs = stmt.executeQuery();
	     while(rs.next())
	     {
	    	 Course courses=new Course();
	    	 courses.setCourse_price(rs.getInt("course_price"));
	    	 courses.setCourseid(rs.getString("courseid"));
	    	 courses.setCoursename(rs.getString("coursename"));
	    	 courses.setProfid(rs.getInt("profid"));
	    	 course.add(courses);
	    	 
	     }

	 
	   }catch(SQLException  se){
		   //throw new CourseDetailsException();
		   se.printStackTrace();
	     
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
		   return course;
	}//end main
	
	
	
	
	
	//Function to add course by student.
	//course ID and student ID are the parameters passed here.
	public boolean student_add_course(String courseId, int studentId) 
	{
		boolean val=false;
		conn=DBUtils.getConnection();
		   //Connection conn = null;
		   PreparedStatement stmt = null;
		   int setprice=0;
		   try{
			   
			   
		
			      
			  	stmt = conn.prepareStatement(SQLConstants.SEARCH_COURSE_INFO);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			 int price  = rs.getInt("course_price");
	         String cid = rs.getString("courseid");
	         if(cid.equals(courseId)) {
	        	 setprice=price;
	        	 break;
	         }
		}
			   
			      stmt = conn.prepareStatement(SQLConstants.ADD_STD_COURSE);
			   
			 
			      //Bind values into the parameters.
			      stmt.setInt(1, studentId);  // This would set age
			      stmt.setString(2,courseId);
			      stmt.setInt(3, setprice);
			      int row=stmt.executeUpdate();
			      if(row==0)
			    	  val= false;
			      else
			    	  val=true;

			   }catch(SQLException se){
				   
				   se.printStackTrace();
				   //throw new StudentAddCourseException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		
		return val;
	}
	//Function to drop a course by student.
	//course ID and student ID are the parameters passed here.
	public boolean student_drop_course(String courseId, int studentId) 
	{
		boolean val=false;
		conn=DBUtils.getConnection();
		//Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			     
			      stmt = conn.prepareStatement(SQLConstants.STD_DROP_COURSE);
			      stmt.setString(1, courseId);
			      stmt.setInt(2, studentId);
			      
			      
			      int row=stmt.executeUpdate();
			      if(row==0) {
			    	  val= false;
			      }
			      else
			    	  val=true;
			           
			   
			   

			   }catch(SQLException  se){
				   se.printStackTrace();
			      //throw new StudentDropCourseException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		
		
		return val;
	}
	//Function to pay the fees for each course by student.
	//student ID is the parameter passed here.
	public int course_payment(int stdid) 
	{
		
		conn=DBUtils.getConnection();	
		//Connection conn = null;
		   PreparedStatement stmt = null;
		   int count=0;
		   
		   try{
			
			      stmt = conn.prepareStatement(SQLConstants.COURSE_PAYMENT);
			      stmt.setInt(1,stdid);
			      
			      ResultSet rs = stmt.executeQuery();
			     
			      while (rs.next())
			      {
			    	  int price  = rs.getInt("course_price");
			    	  count=count+price;
			      }
			    
			   }catch(SQLException se){
				   //throw new CoursePamentViewException();
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		
		return count;
	}
	//Function to add payment in the table.
	//student ID,amount,mode of payment and status are the parameters passed here.
	public List<Payment> add_payment_in_table(int stdid,int amount,String mode_of_payment,String status)
	{
		
		conn=DBUtils.getConnection();
		//Connection conn = null;
		List<Payment> list =new ArrayList<>();
		   PreparedStatement stmt = null;
		    
		   try{
			  
			      stmt = conn.prepareStatement(SQLConstants.SEARCH_DO_COURSE_PAYMENT);
			      stmt.setInt(1, stdid); 
			      ResultSet rs = stmt.executeQuery();
			    
			     if( rs.next()==false )
			     { 
			    	 stmt = conn.prepareStatement(SQLConstants.ADD_PAYMENT_IN_TABLE);
			      
			  
			   
			      stmt.setInt(1, stdid);  // This would set age
			      stmt.setInt(2,amount);
			      stmt.setString(3,mode_of_payment);
			      stmt.setString(4, status);
			      stmt.executeUpdate();
			     
			      
			     
			     }
			    
		    	
			      
			      Payment pay=new Payment();
			      pay.setMode_of_payment(rs.getString("Mode_of_payment"));
			      pay.setStatus(rs.getString("Status"));
			      pay.setStudentid(rs.getInt("Studentid"));
			      pay.setTotal_payment(rs.getInt("total_payment"));
			      list.add(pay);
			     
		 }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		   return list;
			}
	
	//Function to do payment for each course by each student.
	//student ID ,amount, and mode of payment are the parameters passed here.
	public boolean do_course_payment(int stdid,int amount, String mode) 
	{
		boolean val=false;
		conn=DBUtils.getConnection();
		//Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			
			      stmt = conn.prepareStatement(SQLConstants.SEARCH_DO_COURSE_PAYMENT);
			      stmt.setInt(1, stdid); 
			      ResultSet rs = stmt.executeQuery();
			      rs.next();
			      int totalpay= rs.getInt("total_payment");
			    
			    		  
			    	if(totalpay==amount)
			    	{
			    		 
			    		 stmt = conn.prepareStatement(SQLConstants.DO_COURSE_PAYMENT);
			    		
					      stmt.setString(1,mode);
					      stmt.setString(2, "PAYMENT DONE");
					      stmt.setInt(3, stdid);
					      int row=stmt.executeUpdate();
					      if(row==0) {
					    	  val= false;
					      }
					      else
					    	  val=true;
					     
					  
			    	}
			    	else {
			    		val= false;
			    	}
			 
			      

			   }catch(SQLException se){
				   se.printStackTrace();
			     //throw new CoursePamentViewException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }

		   return val;
	}
	
	
	//Function to view the grade card of each student.
	//student ID is the parameter passed here.
	public List<Grade> viewGradeCard(int stdid) {//throws ViewGradeCardException {
		conn=DBUtils.getConnection();
		//Connection conn = null;
		   PreparedStatement stmt = null;
		   int count=0;
		   List<Grade> list =new ArrayList<>();
		   try{
			  
			      stmt = conn.prepareStatement(SQLConstants.VIEW_GRADE_CARD);
			      stmt.setInt(1,stdid);
			      
			      ResultSet rs = stmt.executeQuery();
			      while (rs.next())
			      {
			    	  Grade grade=new Grade();
			    	  grade.setCourseid(rs.getString("Courseid"));
			    	  grade.setGrade(rs.getString("grade"));
			    	  grade.setProfid(rs.getInt("profid"));
			    	  grade.setStd_id(stdid);
			    	  list.add(grade);
			    
			    	 
			      }
			      

			   }catch(SQLException se){
				   se.printStackTrace();
			      //throw new ViewGradeCardException();
			   }catch(Exception e){
			      //Handle errors for Class.forName
				   e.printStackTrace();
			   }

		
		return list;
		
	}
	}
	
	


