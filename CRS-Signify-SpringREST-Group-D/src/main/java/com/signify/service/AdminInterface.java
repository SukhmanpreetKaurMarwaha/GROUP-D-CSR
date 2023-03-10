/**
 * 
 */
package com.signify.service;

import java.sql.ResultSet;
import java.util.*;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.exception.AdminExceptions;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentDBViewException;

/**
 * @author HP
 *
 */
public interface AdminInterface {
	public boolean addAdmin(Admin admin) ;
	//public boolean addAdmin(String name,int id,String Designation,String Password) throws AdminExceptions;
	public boolean addProfessor(Professor prof);
	//public boolean addProfessor(int proffId, String pass, String name,String designation,String doj) throws AdminExceptions;
	//public void assignCourse(int studentId,String courseCode);
	public boolean approveStudent(int studentId) ;
	public List<Student> viewRegisteredStudents();
	//catalog
	public boolean addCourse(Course course) ;
	//public boolean addCourse(String courseId, String courseName, int courseProf,int course_price) throws CourseCreateExceptions;
	public boolean deleteCourse(String courseId) ;
	public List<Course> viewCourseDetails(); //throws CourseDetailsException;
}
