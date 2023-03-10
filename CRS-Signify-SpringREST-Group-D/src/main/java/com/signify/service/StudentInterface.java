package com.signify.service;

import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Grade;
import com.signify.bean.Payment;
import com.signify.bean.Student;
import com.signify.exception.AdminExceptions;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewGradeCardException;
import com.signify.exception.ViewUnapprovedStudentsException;

public interface StudentInterface {
	//public void changePassword(String passwordNew);
	public boolean register(Student student) ;
	public List<Grade> viewGradeCard(int studentId );// throws ViewGradeCardException;
	public boolean addCourse(String courseCode,int studentid);
	//registered course
	//public void viewGrade(int studentId);
	//public boolean dropCourse(Course courseCode,Student studentid) ;
	public boolean dropCourse(String Coursecode, int studentid) ;
	public boolean dopayment(Payment payment); 
	public List<Student> view_unapproved_stds(); //throws ViewUnapprovedStudentsException;
	//public int viewpayment(int id) ;
	public List<Payment> viewpayment(int id);
}
