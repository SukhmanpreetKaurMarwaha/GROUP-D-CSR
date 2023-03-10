package com.signify.restcontroller;

/**
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Grade;
import com.signify.bean.Payment;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewEnrolledStudentsException;
import com.signify.exception.ViewGradeCardException;
import com.signify.exception.ViewUnapprovedStudentsException;
import com.signify.service.AdminServiceIml;
import com.signify.service.StudentServiceIml;


/**
 * @author HP
 *
 */

@RestController
public class StudentRestControllerAPI {

	/**
	 * @param args
	 * @throws AdminExceptions 
	 * @throws StudentDBViewException 
	 * @throws CourseCreateExceptions 
	 * @throws DeleteCourseException 
	 * @throws CourseDetailsException 
	 * @throws StudentDropCourseException 
	 * @throws StudentAddCourseException 
	 * @throws ViewGradeCardException 
	 * @throws CoursePamentViewException 
	 * @throws ViewUnapprovedStudentsException 
	 * @throws ViewEnrolledStudentsException 
	 */
	@Autowired
	private StudentServiceIml studentservice;
	@Autowired
	private Student student;
	@Autowired
	private Professor prof;
	@Autowired
	private Course course;
	@Autowired
	private Payment payment1;
	@Autowired
	private Grade grade;
	
	//case 4 view payment
//	@RequestMapping(method = RequestMethod.POST,
//		    value = "/viewpayment")
//	@ResponseBody
//	public ResponseEntity<Integer> viewpayment(){
//		int ans=studentservice.viewpayment(student);
//		return new ResponseEntity<Integer>(ans,HttpStatus.OK);
//	}
//	
	
	//case drop course std
	@RequestMapping("/dropcourse/{id}/{studentid}")
	@ResponseBody
 public ResponseEntity<String> dropCourse(@PathVariable String id, @PathVariable int studentid) {
	
	
	if(studentservice.dropCourse(id, studentid))
	{	//if(adminservice.addAdmin(name,id,Designation,Password))
		return new ResponseEntity<String>("course dropped", HttpStatus.OK);
}
		return new ResponseEntity<String>( HttpStatus.NOT_FOUND);
	
}
	//case add course std
	@RequestMapping(
		    method = RequestMethod.POST,
		    value = "/joincourse")
		@ResponseBody
	 public ResponseEntity<String> createCourse(@RequestBody Map<String,String> param) {
		
		
		String id= param.get("courseid");
		int studentid =Integer.parseInt(param.get("studentid"));
		
		student.setStudentid(studentid);
		course.setCourseid(id);
		
		if(studentservice.addCourse(id,studentid))
		//if(adminservice.addAdmin(name,id,Designation,Password))
			return new ResponseEntity<String>("added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		
	}

	//do payment
	@RequestMapping(
		    method = RequestMethod.POST,
		    value = "/dopayment")
		@ResponseBody
	 public ResponseEntity<String> dopayment(@RequestBody Map<String,String> param) {
		
		//System.out.println("111");
		int stdid =Integer.parseInt(param.get("Studentid"));
		int payment=Integer.parseInt(param.get("total_payment"));
		String mode= param.get("Mode_of_payment");
		
		//System.out.println(stdid);
		payment1.setStudentid(stdid);
		payment1.setTotal_payment(payment);
		payment1.setMode_of_payment(mode);
		
		if(studentservice.dopayment(payment1))
		//if(adminservice.addAdmin(name,id,Designation,Password))
			return new ResponseEntity<String>("paid", HttpStatus.OK);
		else
			return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		
	}
	
	
	//view payment
			@RequestMapping("/viewpayment/{id}")
			  @ResponseBody
		 public ResponseEntity viewpayment(@PathVariable int id) {
				
				List<Payment> payment1=studentservice.viewpayment(id);
			//System.out.println(payment1.getStatus());
			//System.out.println(payment1.getMode_of_payment());	
			
			if(payment1!=null)
			{	//if(adminservice.addAdmin(name,id,Designation,Password))
				return new ResponseEntity<List<Payment>> (payment1, HttpStatus.OK);
		
			}
				return new ResponseEntity ( HttpStatus.NOT_FOUND);
			
		}
	
			
			
			
			//view grade card
			@RequestMapping("/viewgradecard/{id}")
			  @ResponseBody
		 public ResponseEntity viewgradecard(@PathVariable int id) {
				
				List<Grade> list=studentservice.viewGradeCard(id);
			
			
			if(list!=null)
			{	//if(adminservice.addAdmin(name,id,Designation,Password))
				return new ResponseEntity<List<Grade>> (list, HttpStatus.OK);
		
			}
				return new ResponseEntity( HttpStatus.NOT_FOUND);
			
		}
			
			
			
	//public void display() {
	/*
	public static void Studentfunc(int id) throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewUnapprovedStudentsException, ViewEnrolledStudentsException{ 
		
		System.out.println("\nWELCOME TO STUDENT\n"+"=======================");
		Scanner in = new Scanner(System.in);  
		System.out.println("STUDENT MENU");
		
		System.out.println("1: JOIN A COURSE");//done//
		System.out.println("2: DROP A COURSE");//done//
		System.out.println("3: VIEW GRADE CARD");//done//
		System.out.println("4: VIEW TOTAL PAYMENT");//done
		System.out.println("5: PAY FOR COURSES");//done//
		System.out.println("6:LOGOUT");//done
		
		System.out.println("Enter Your Choice "); 
        int choice1 = in.nextInt();
        switch(choice1)
        {
        case 1: System.out.println("YOUR CHOICE: JOIN A COURSE");
        		
        		for(int i=0;i<4;i++) {
        			System.out.println("ENTER COURSE CODE OF COURSE YOU WANT TO REGISTER "); 
    	        	String course_choice1 = in.next();  	
    	        	StudentServiceIml object=new StudentServiceIml();
    	        	object.addCourse(course_choice1,id);
    	        }
        		StudentRestControllerAPI aP=new StudentRestControllerAPI();
   			 aP.Studentfunc(id);

        break;
        case 2: System.out.println("YOUR CHOICE: DROP A COURSE");
        System.out.println("ENTER COURSE CODE OF COURSE YOU WANT TO DROP "); 
    	String course_drop1 = in.next(); 
    	StudentServiceIml object=new StudentServiceIml();
    	object.dropCourse(course_drop1,id);
    	StudentRestControllerAPI aL=new StudentRestControllerAPI();
			 aL.Studentfunc(id);
        break;
        case 3: System.out.println("YOUR CHOICE: VIEW GRADE CARD");
        StudentServiceIml obj1=new StudentServiceIml();
    	obj1.viewGradeCard(id);

        StudentRestControllerAPI am=new StudentRestControllerAPI();
		 am.Studentfunc(id);
        break;
        case 4: System.out.println("YOUR CHOICE: VIEW TOTAL PAYMENT");
        StudentServiceIml object1=new StudentServiceIml();
        object1.viewpayment(id);
        //System.out.println("Make payment "); 
    	//String course_choice1 = in.next();
        StudentRestControllerAPI aK=new StudentRestControllerAPI();
		 aK.Studentfunc(id);
        
        break;
        case 5:System.out.println("YOUR CHOICE: PAY FOR COURSES");
        System.out.println("ENTER AMOUNT TO BE PAID "); 
    	int amount = in.nextInt(); 
    	 System.out.println("ENTER MODE OF PAYMENT"); 
     	String mode = in.next(); 
     	StudentServiceIml object5=new StudentServiceIml();
        object5.dopayment(id,amount,mode);
        StudentRestControllerAPI aK1=new StudentRestControllerAPI();
		 aK1.Studentfunc(id);
        
        case 6: System.out.println("YOUR CHOICE: LOGOUT");
        MainMenuRestControllerAPI m=new MainMenuRestControllerAPI();
		m.Menufunc();
        break;
        default:System.out.println("INVALID INPUT!");
        }
		
		
		
        
        
	
	}*/

}


