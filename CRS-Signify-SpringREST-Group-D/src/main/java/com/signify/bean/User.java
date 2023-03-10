/**
 * 
 */
package com.signify.bean;
import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * @author ALRAHIMA
 *
 */
@Component
public class User {
	private int Userid;
	private String User_name;
	private String Password;
	private String role;
	
	
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
