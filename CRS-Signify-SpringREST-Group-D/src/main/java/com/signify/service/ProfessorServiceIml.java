package com.signify.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signify.bean.Grade;
import com.signify.bean.Student;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.ViewEnrolledStudentsException;
import com.signify.jdbc.ProfessorDAOImplementation;

//import com.
@Service
public class ProfessorServiceIml implements ProfessorInterface{
	
	@Autowired
	Student std;
	
	
	 //Function To View Enrolled Students From The Database
	public List<Student> viewEnrolledStudents(int pid){
		List<Student> ans=new ArrayList<>();
		ProfessorDAOImplementation view=new ProfessorDAOImplementation();
		 ans=view.viewEnrolledStudents(pid);
		return ans;
	
		
		
		/*catch(ViewEnrolledStudentsException se)
		{
			System.out.println("STUDENTS NOT DISPLAYED");
		}*/
	}

	//Function To Add Grade Details In The Database
	public boolean add_Grade(Grade grade)  {
	
		ProfessorDAOImplementation pgrade=new ProfessorDAOImplementation();
		boolean ans=pgrade.addGrade(grade.getStd_id(),grade.getCourseid(),grade.getGrade(),grade.getProfid());
	if(ans==true)
		return true;
	else 
		return false;
		
	
	}

	
	

}
