/**
 * 
 */
package com.signify.service;

import java.sql.ResultSet;
import java.util.*;

import org.springframework.stereotype.Service;

import com.signify.restcontroller.AdminRestControllerAPI;
import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
//import com.signify.client.CSRDatabasemMenu;
import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.jdbc.AdminDAOImplementation;
import com.signify.jdbc.CourseCatalogDAOImplementation;
import com.signify.jdbc.ProfessorDAOImplementation;
import com.signify.jdbc.StudentDAOImplementation;
import com.signify.jdbc.UserDAOImplementation;

/**
 * @author Tejaswini.S.J
 *
 */
@Service
public class AdminServiceIml implements AdminInterface
{
	//Function To Add Admin Details In The Database
	//public boolean addAdmin(String name,int id,String Designation,String Password) 
	public boolean addAdmin(Admin admin) 
    {
		
			UserDAOImplementation unew=new UserDAOImplementation();
			boolean ans= unew.create_user(admin.getAdminid(),admin.getPassword(),admin.getAdmin_name(),"Admin");
			
			AdminDAOImplementation stdetail= new AdminDAOImplementation();
			boolean ans1=stdetail.admin_db_create(admin.getAdminid(),admin.getAdmin_name(),admin.getDesignation());
			
		
		if(ans==true && ans1==true)
		{
			return true;
		}
	    
	

			return false;
	
    }
	
	
	//Function To Add Professor Details In The Database
	public boolean addProfessor(Professor prof) 
      {
		
		
		UserDAOImplementation unew=new UserDAOImplementation();
		boolean cal1=unew.create_user(prof.getProf_id(),prof.getPassword(),prof.getProf_name(),"Professor");
		
		ProfessorDAOImplementation stdetail= new ProfessorDAOImplementation();
		boolean cal2=stdetail.professor_db_create(prof.getProf_id(),prof.getProf_name(),prof.getDesignation(),prof.getDoj());

		if (cal1==true && cal2==true)
		{
			return true;
		}
    	  //System.out.println("\nPROFESSOR ADDED\n");
    	
		
		return false;
      }
	//Function To View Registered Students Details From The Database
      public List<Student> viewRegisteredStudents() //throws StudentDBViewException
      {
    	  List<Student> viewstd =new ArrayList<>();
    	//  try {
    	  StudentDAOImplementation unew=new StudentDAOImplementation();
  		   viewstd=unew.student_db_view();
  		
    	/* }catch(StudentDBViewException e)
    	
    	  {
    		 System.out.println("STUDENT NOT REGISTERED");
    		  
    	  }*/
    	  return viewstd;
      }
      
      
      //Function To Add Course Details In The Database
     public boolean addCourse(Course course)  {
   
    	  
    	  
    	  CourseCatalogDAOImplementation cfdetail= new CourseCatalogDAOImplementation();
		   boolean addcourse=cfdetail.catalog_db_create(course.getCourseid(),course.getCoursename(),course.getProfid(),course.getCourse_price());
	
		   if(addcourse==true)
		   {
			   return true;
		   }
    	  
    	  
    		  return false;
    	  
    	
    	  }
  	      
  	
    //Function To Delete Course Details From The Database
  	public boolean deleteCourse(String courseId)  {
  		boolean deletecourse1=false;
  		try {
  		CourseCatalogDAOImplementation cf1detail= new CourseCatalogDAOImplementation();
  		boolean deletecourse= cf1detail.deleteCourse(courseId);
  		
  		if(deletecourse==true)
  		{
  			deletecourse1=true;
  		}
		 // System.out.println("\nCOURSE REMOVED\n");
  	  }catch(DeleteCourseException e)
  	  {
  		e.printStackTrace();
  		  deletecourse1=false;
  		 
  	  }
  		return deletecourse1;
  	}

  	 //Function To View Course Details In The Database
  	public List<Course> viewCourseDetails() //throws CourseDetailsException
  	{
  		//ResultSet ans2=null;
  		List<Course> list=new ArrayList<>();
  		CourseCatalogDAOImplementation cf1detail= new CourseCatalogDAOImplementation();
  		 list=cf1detail.CourseDetail();
		  return list;
    	 /* }catch(CourseDetailsException e)
    	  {
    		  System.out.println("COURSE CANNOT BE VIEWED");
    	  }
  		 return ans2;*/
  	}
	@Override
	//Function Approve Student Registration In The Database
	public boolean approveStudent(int studentId) {
		// TODO Auto-generated method stub
		//try {
			
			AdminDAOImplementation approve= new AdminDAOImplementation();
			boolean ans6=approve.approvestd(studentId,"approved");
			//System.out.println("\nSTUDENT APPROVED \n");
			if(ans6==true)
			{
				return true;
			}
			return false;
			

  	/*  }catch(StudentDBViewException e)
  	  {
  		System.out.println("\nSTUDENT CANNOT BE APPROVED\n");
  	  }*/
		}


	




	
		
	}

