/**
 * 
 */
package com.signify.jdbc;

import com.signify.exception.AdminExceptions;
import com.signify.exception.StudentDBViewException;

/**
 * @author HP
 *
 */
public interface UserDAOInterface {

	 public boolean create_user(int id,String pass,String name,String role) ;
	 public boolean login(int userid1, String pwd, String name,String Role1) ;
}
