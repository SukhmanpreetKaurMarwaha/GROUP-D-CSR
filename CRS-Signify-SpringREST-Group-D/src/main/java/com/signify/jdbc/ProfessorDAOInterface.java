/**
 * 
 */
package com.signify.jdbc;

import java.util.List;

import com.signify.bean.Student;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.ViewEnrolledStudentsException;

/**
 * @author HP
 *
 */
public interface ProfessorDAOInterface {
	public boolean professor_db_create(int proffId, String name,String designation,String doj);
	public boolean addGrade(int studentid,String courseid,String grade,int profid);
	public List<Student> viewEnrolledStudents(int pid);
}
