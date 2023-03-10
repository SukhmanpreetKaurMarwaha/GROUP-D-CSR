/**
 * 
 */
package com.signify.jdbc;

import java.util.List;

import com.signify.bean.Student;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.UpdatePasswordException;
import com.signify.exception.ViewUnapprovedStudentsException;

/**
 * @author HP
 *
 */
public interface StudentDAOInterface {
	public boolean student_db_create(int studentId, String name, String branch, String batch, String status );
	public List<Student> student_db_view(); //throws StudentDBViewException;
	public boolean update_pass(int id, String newpass, String oldpass);
	public List<Student> view_unapproved_stds() ;//throws ViewUnapprovedStudentsException;
	public boolean std_login(int id,String userpass,String username);

}
