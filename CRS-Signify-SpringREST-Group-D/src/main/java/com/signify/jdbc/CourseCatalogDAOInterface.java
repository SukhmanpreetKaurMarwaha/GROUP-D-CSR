/**
 * 
 */
package com.signify.jdbc;

import java.sql.ResultSet;
import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Grade;
import com.signify.bean.Payment;
import com.signify.exception.CourseCreateExceptions;
import com.signify.exception.CourseDetailsException;
import com.signify.exception.CoursePamentViewException;
import com.signify.exception.DeleteCourseException;
import com.signify.exception.StudentAddCourseException;
import com.signify.exception.StudentDropCourseException;
import com.signify.exception.ViewGradeCardException;

/**
 * @author HP
 *
 */
public interface CourseCatalogDAOInterface {
	public boolean catalog_db_create(String courseId, String courseName, int courseProf,int courseprice) throws CourseCreateExceptions;
	public boolean deleteCourse(String courseid1) throws DeleteCourseException;
	public List<Course> CourseDetail(); //throws CourseDetailsException;
	public boolean student_add_course(String courseId, int studentId) throws StudentAddCourseException;
	public boolean student_drop_course(String courseId, int studentId) ;
	public int course_payment(int stdid);
	public List<Payment> add_payment_in_table(int stdid,int amount,String mode_of_payment,String status);
	public boolean do_course_payment(int stdid,int amount, String mode) ;
	public List<Grade> viewGradeCard(int stdid);// throws ViewGradeCardException;
}
