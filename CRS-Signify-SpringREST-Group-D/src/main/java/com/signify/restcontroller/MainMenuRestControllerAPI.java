package com.signify.restcontroller;
import java.sql.ResultSet;
import java.util.*;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Grade;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.UpdatePasswordException;
import com.signify.exception.ViewEnrolledStudentsException;
import com.signify.exception.ViewGradeCardException;
import com.signify.exception.ViewUnapprovedStudentsException;
import com.signify.jdbc.CourseCatalogDAOImplementation;
import com.signify.jdbc.StudentDAOImplementation;
import com.signify.jdbc.UserDAOImplementation;
import com.signify.service.AdminServiceIml;
import com.signify.service.StudentServiceIml;
import com.signify.service.UserServiceIml;


@RestController
public class MainMenuRestControllerAPI {
	/**
	 * @param args
	 * @throws AdminExceptions 
	 * @throws StudentDBViewException 
	 * @throws CourseCreateExceptions 
	 * @throws DeleteCourseException 
	 * @throws CourseDetailsException 
	 * @throws CoursePamentViewException 
	 * @throws ViewGradeCardException 
	 * @throws StudentAddCourseException 
	 * @throws StudentDropCourseException 
	 * @throws ViewUnapprovedStudentsException 
	 * @throws ViewEnrolledStudentsException 
	 */
	
	@Autowired
	private UserServiceIml userservice;
	@Autowired
	private StudentServiceIml studentservice;
	@Autowired
	private Student std;
	@Autowired
	private User user;
	
	//add Student
	@RequestMapping(
		    method = RequestMethod.POST,
		    value = "/addstudent")
		@ResponseBody
	 public ResponseEntity<String> createStudent(@RequestBody Map<String,String> param) {
		
		String name=param.get("Student_name");
		int id= Integer.parseInt(param.get("studentid"));
		String Branch =param.get("Branch");
		String Batch=param.get("Batch");
		String Password=param.get("Password");
		
		std.setStudent_name(name);
		std.setBatch(Batch);
		std.setBranch(Branch);
		std.setPassword(Password);
		std.setStudentid(id);		
		
		if(studentservice.register(std))
		//if(adminservice.addAdmin(name,id,Designation,Password))
			return new ResponseEntity<String>("added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		
	}
	
	//login
	@RequestMapping(
		    method = RequestMethod.POST,
		    value = "/login")
		@ResponseBody
	 public ResponseEntity<String> login(@RequestBody Map<String,String> param) {
		
		String name=param.get("User_name");
		int id= Integer.parseInt(param.get("Userid"));
		String role =param.get("role");
		String Password=param.get("Password");
		
		user.setUser_name(name);
		user.setPassword(Password);
		user.setRole(role);
		user.setUserid(id);
		
		if(role.equals("Student"))
		{
			
			if(userservice.stdlogin(user))
				//if(adminservice.addAdmin(name,id,Designation,Password))
					return new ResponseEntity<String>("login", HttpStatus.OK);
				else
					return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
				
			
		}
		else if(role.equals("Professor") ||role.equals("Admin") )
		{
			if(userservice.login(user))
				//if(adminservice.addAdmin(name,id,Designation,Password))
					return new ResponseEntity<String>("login", HttpStatus.OK);
				else
					return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		
		
		
	}
	//update pass
	
	
	@RequestMapping(
		    method = RequestMethod.POST,
		    value = "/updatepass")
		@ResponseBody
	 public ResponseEntity<String> updatepass(@RequestBody Map<String,String> param) {
		
		String newpass=param.get("newpass");
		String Password=param.get("Password");
		int id= Integer.parseInt(param.get("Userid"));
		user.setPassword(Password);
		user.setUserid(id);
		
		if(userservice.updatePassword(newpass,user))
			
				return new ResponseEntity<String>("updated", HttpStatus.OK);
			else
				return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	
	/*public static void Menufunc() throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewUnapprovedStudentsException, ViewEnrolledStudentsException {
		
		//adding admin in the database
		
		/*if(!admin_db.containsKey(9))
		{
			AdminService anew=new AdminService();
	        anew.addAdmin(9,"zero","Prem","Dean");
	        //System.out.println("mem added");
	       // flag=true;
		}
		System.out.println("WELCOME TO THE CSR APPLICATION\n"+"===========================\n"+"MAIN MENU\n"+"1.REGISTRATION FOR NEW STUDENT\n"+"2.LOGIN\n"+"3.UPADATE PASSWORD\n"+"4.EXIT");
		Scanner in = new Scanner(System.in);  
        System.out.print("Enter number "); 
        boolean c=true;
        int x = in.nextInt();
		switch(x) {
		case 1:
			
			System.out.println("Registration for student");

			System.out.print("Enter Name ");
			String name = in.next(); 
			
			 System.out.println("ENTER PASSWORD");
			 String pass = in.next();
			 
			
			
			System.out.print("Enter Roll Number- ");
			int studentId = in.nextInt(); 
			
			System.out.print("Enter Branch- ");
			String branch=in.next();
			
			System.out.print("Enter Batch- ");
			String batch=in.next();
			StudentServiceIml snew=new StudentServiceIml();
	        snew.register(studentId,pass, name, branch, batch);
			//Student s=new Student();
			//s.Studentfunc();
			
			break;
		case 2:
			
			//boolean flag=false;
			System.out.println("\nLOGIN USER\n"+"==============");
			
			System.out.println("ENTER ID");
			int id = in.nextInt(); 
			
			System.out.println("ENTER USER NAME");
			 String username = in.next(); 
			
			 System.out.println("ENTER ROLE");
			 String role = in.next(); 
			
			  
			 System.out.println("ENTER PASSWORD");
			 String userpass = in.next();
			 boolean ans=false;
			 try {
			 if(role.equals("Professor") || role.equals("professor")||role.equals("Admin") || role.equals("admin"))
			 { 
				 UserDAOImplementation unew=new UserDAOImplementation();
			 ans=unew.login(id,userpass,username,role);
			 }
			 else if (role.equals("Student") || role.equals("student")){
				 StudentDAOImplementation stnew =new StudentDAOImplementation();
				 ans=stnew.std_login(id,userpass,username);
			 }
			 else {
				 System.out.println("\nWRONG ROLE\n");
			 }
			 if(ans==true)
			 {
				 System.out.println("\nLOGIN SUCCESS\n");
				 if(role.equals("Student") || role.equals("student"))
				 {
					 StudentRestControllerAPI s1=new StudentRestControllerAPI();
					 s1.Studentfunc(id);
				 }
				 else if(role.equals("Professor") || role.equals("professor"))
				 {
					 System.out.println("ENTER COURSE ID ");
					 String cid=in.next();
					 ProfessorRestControllerAPI p=new ProfessorRestControllerAPI();
					 p.Professorfunc(id,cid);
				 }
				 else if(role.equals("Admin") || role.equals("admin"))
				 {
					 AdminRestControllerAPI a=new AdminRestControllerAPI();
					// a.Adminfunc();	
				 }
				 else {
					 System.out.println("WRONG ROLE");
				 }
			 }
			 else {
				 System.out.println("\nTRY AGAIN\n");
			 }}
			 catch(StudentDBViewException e)
			 {
				 System.out.println("\nTRY AGAIN\n");
			 }
			
			 break;
			 
		case 3:
			System.out.println("\nUPDATE PASSWORD\n"+"===================");
			System.out.println("ENTER ID");
			int id1 = in.nextInt(); 
			System.out.println("ENTER ROLE");
			String role1 = in.next(); 
			System.out.println("ENTER OLD PASSWORD");
			String oldPass = in.next();
			System.out.println("ENTER NEW PASSWORD");
			String newPass = in.next();
			// if(role1.equals("Student"))
			// {
			try {
				 StudentDAOImplementation y=new StudentDAOImplementation();	
				y.update_pass(id1,newPass,oldPass);
				System.out.println("\nPASSWORD UPDATED\n");
			} catch (UpdatePasswordException e) {
				// TODO Auto-generated catch block
				System.out.println("PASSWORD NOT UPDATED");
			}
				
	
		   break;
		case 4:
			System.out.println("EXIT");
			c=false;
			break;
			
		}
	
		//in.close();
		
	}*/
}





