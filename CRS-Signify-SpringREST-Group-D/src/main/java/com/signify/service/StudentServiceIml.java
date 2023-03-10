/**
 * 
 */
package com.signify.service;
import com.signify.jdbc.CourseCatalogDAOImplementation;
import com.signify.jdbc.StudentDAOImplementation;
import com.signify.jdbc.UserDAOImplementation;
import com.signify.bean.Course;
import com.signify.bean.Grade;
import com.signify.bean.Payment;
import com.signify.bean.Student;
import com.signify.exception.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP
 *
 */
@Service
public class StudentServiceIml implements StudentInterface {
	
	@Autowired
	Grade grade;
	
	private Payment p;
	 //Function To Register Student Details In The Database
	public boolean register(Student student) 
	{
		
		UserDAOImplementation unew=new UserDAOImplementation();
		boolean cal1=unew.create_user(student.getStudentid(),student.getPassword(),student.getStudent_name(),"Student");
		
		StudentDAOImplementation stdetail= new StudentDAOImplementation();
		boolean cal2=stdetail.student_db_create(student.getStudentid(),student.getStudent_name(),student.getBranch(),student.getBatch(),"yet_to_approve");
		
		if (cal1==true && cal2==true)
		{
			return true;
		}
    	  //System.out.println("\nPROFESSOR ADDED\n");
    	
		
		return false;
		
		
		
	}
	 //Function To View Grade  Details From The Database
	public List<Grade> viewGradeCard(int studentId ) //throws ViewGradeCardException
	{
		List<Grade> list=new ArrayList<>();
		
		//try {
		//System.out.println("GRADE CARD ");
		CourseCatalogDAOImplementation o1=new CourseCatalogDAOImplementation();
		list=o1.viewGradeCard(studentId);
		
	//}
	//catch(ViewGradeCardException e)
	//{
	//	System.out.println("GRADE NOT DISPLAYED");
	//}
		return list;
	
	}
	
	 //Function To Add Course Details to A Student In The Database
	public boolean addCourse(String courseCode,int studentid) {
		
		
		CourseCatalogDAOImplementation stadd=new CourseCatalogDAOImplementation();
		boolean ans=stadd.student_add_course(courseCode,studentid);
  	    //System.out.println("\nCOURSE IS ADDED\n");
		if (ans==true)
		{
			return true;
		}
	
		return false;
  	
		
		
    }

	//Function To Remove Course Assigned To A Student In The Database
	public boolean dropCourse(String Coursecode, int studentid) 
    {
		
		CourseCatalogDAOImplementation stadd=new CourseCatalogDAOImplementation();
		boolean res= stadd.student_drop_course(Coursecode,studentid);
  	    return res;
		
		
    }
	//Function To View Payment Detail From The Database
	public List<Payment> viewpayment(int id) 
	{
		
		//List<Payment> pay=new ArrayList<>();
		int ans=0;
		//List<Payment> list=new ArrayList<>();
		CourseCatalogDAOImplementation stadd=new CourseCatalogDAOImplementation();
		 ans=stadd.course_payment(id);
		//System.out.println("TOTAL PAYMENT IS " +ans);
		CourseCatalogDAOImplementation stadd1=new CourseCatalogDAOImplementation();
		//int ans=stadd.course_payment(stdid);
		
		List<Payment>  list=stadd1.add_payment_in_table(id,ans,"NOT SPECIFIED","PAYMENT NOT DONE");
		//p.setMode_of_payment(null);
		//pay.add(payment.to);
		
		return list;
	}

	//Function To Make a Payment And Choose The Mode
	public boolean dopayment(Payment payment) 
	{
		
		CourseCatalogDAOImplementation staddr=new CourseCatalogDAOImplementation();
		boolean value=staddr.do_course_payment(payment.getStudentid(),payment.getTotal_payment(),payment.getMode_of_payment());
		if(value==true)
		{
			return true;
		}
		return false;
		
	}
	//Function To View Unapproved Student Details From The Database
	public List<Student> view_unapproved_stds() //throws ViewUnapprovedStudentsException
	{
		List<Student> list=new ArrayList<>();
		//try {
		StudentDAOImplementation glan= new StudentDAOImplementation();
		list=glan.view_unapproved_stds();
		
		return list;
		
		
		//}
		/*catch(ViewUnapprovedStudentsException e)
		{
			System.out.println("NO UNAPPROVED STUDENTS");
		}*/
	}
	
	
	
}
