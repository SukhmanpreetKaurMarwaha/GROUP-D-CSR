/**
 * 
 */
package com.signify.bean;
import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * @author Tejaswini.S.J
 *
 */
@Component
public class Admin
{

	private int Adminid;
    private String Admin_name;
    private String Designation;
    private String Password;
    
    public int getAdminid() {
		return Adminid;
	}
	public void setAdminid(int adminid) {
		Adminid = adminid;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}



}
