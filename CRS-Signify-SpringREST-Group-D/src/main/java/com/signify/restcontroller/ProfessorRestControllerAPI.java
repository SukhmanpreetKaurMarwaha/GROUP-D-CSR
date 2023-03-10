package com.signify.restcontroller;

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

import com.signify.bean.Grade;
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
import com.signify.service.AdminInterface;
import com.signify.service.AdminServiceIml;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorServiceIml;
/**
 * @author HP
 *
 */
@RestController
public class ProfessorRestControllerAPI {

	/**
	 * @param args
	 * @throws AdminExceptions 
	 * @throws StudentDBViewException 
	 * @throws CourseCreateExceptions 
	 * @throws DeleteCourseException 
	 * @throws CourseDetailsException 
	 * @throws ViewUnapprovedStudentsException 
	 * @throws CoursePamentViewException 
	 * @throws ViewGradeCardException 
	 * @throws StudentAddCourseException 
	 * @throws StudentDropCourseException 
	 * @throws ViewEnrolledStudentsException 
	 */
	
	@Autowired
	Grade gradeadd;
	@Autowired
	ProfessorServiceIml professservice;
	@Autowired
	Student std;
	
	
	//ADD grade
	@RequestMapping(
		    method = RequestMethod.POST,
		    value = "/addgrade")
		@ResponseBody
	 public ResponseEntity<String> addgrade(@RequestBody Map<String,String> param) {
		
		//System.out.println("111");
		int stdid =Integer.parseInt(param.get("std_id"));
		int profid=Integer.parseInt(param.get("profid"));
		String courseid= param.get("Courseid");
		String grade= param.get("grade");
		
		//System.out.println(stdid);
		gradeadd.setCourseid(courseid);
		gradeadd.setGrade(grade);
		gradeadd.setProfid(profid);
		gradeadd.setStd_id(stdid);
		
		
		if(professservice.add_Grade(gradeadd))
		//if(adminservice.addAdmin(name,id,Designation,Password))
			return new ResponseEntity<String>("grade_added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
		
	}
	
	
	//view enrolled students
	@RequestMapping("/viewenrolledstd/{id}")
	  @ResponseBody
    public ResponseEntity viewenrolledstd(@PathVariable int id) {
	
	
		List<Student> list= professservice.viewEnrolledStudents(id);
		if(list==null)
		{
			return new ResponseEntity<String>("NO Student Found", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		}
		//if(adminservice.addAdmin(name,id,Designation,Password))
		
	
}
	
	
	
	
	/*public static void Professorfunc(int pid,String cid) throws AdminExceptions, StudentDBViewException, CourseCreateExceptions, DeleteCourseException, CourseDetailsException, StudentDropCourseException, StudentAddCourseException, ViewGradeCardException, CoursePamentViewException, ViewUnapprovedStudentsException, ViewEnrolledStudentsException {
		// TODO Auto-generated method stub
		System.out.println("\nWELCOME TO PROFESSOR\n"+"=============\n");
		Scanner in = new Scanner(System.in);  
		System.out.println("PROFESSOR MENU");
		System.out.println("1: VIEW ENROLLED STUDENTS ");//not done//
		System.out.println("2: ADD GRADE ");//done//
		System.out.println("3: EXIT");//done
		
		System.out.println("Enter Your Choice ");
		int choice1 = in.nextInt();
        switch(choice1)
        {
        case 1: System.out.println("YOUR CHOICE: VIEW ENROLLED STUDENTS");
        
		ProfessorInterface star= new ProfessorServiceIml();
        star.viewEnrolledStudents(pid);
        ProfessorRestControllerAPI aP=new ProfessorRestControllerAPI();
			 aP.Professorfunc(pid,cid);
        break;
        case 2: System.out.println("YOUR CHOICE: ADD GRADE ");
        System.out.println("ENTER STUDENT ID ");
        int stdid=in.nextInt();
        
        
        System.out.println("ENTER GRADE ");
        String gradestd=in.next();
        

		ProfessorInterface func= new ProfessorServiceIml();
        func.add_Grade(stdid,cid,gradestd,pid);
        ProfessorRestControllerAPI aH=new ProfessorRestControllerAPI();
			 aH.Professorfunc(pid,cid);
        
        break;
        case 3: System.out.println("YOUR CHOICE: LOGOUT");
        MainMenuRestControllerAPI m=new MainMenuRestControllerAPI();
		m.Menufunc();
        break;
        default:System.out.println("INVALID INPUT!");
        }
		
		


		}*/

}





