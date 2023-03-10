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
public interface AdminDAOInteface {
	public boolean admin_db_create(int adminId ,String adminName,String AdminDesignation) throws AdminExceptions;
	public boolean approvestd(int stdid, String status) throws StudentDBViewException;
}
