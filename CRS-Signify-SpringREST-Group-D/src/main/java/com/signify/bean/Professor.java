/**
 * 
 */
package com.signify.bean;
import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * @author HP
 *
 */
@Component
public class Professor {

	/**
	 * @param args
	 */
	//professor
	
	private int prof_id;
	private String prof_name;
	private String designation;
	private String DOJ;	
	private String Password;
	
	
	
	public int getProf_id() {
		return prof_id;
	}
	public void setProf_id(int prof_id) {
		this.prof_id = prof_id;
	}
	public String getProf_name() {
		return prof_name;
	}
	public void setProf_name(String prof_name) {
		this.prof_name = prof_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDoj() {
		return DOJ;
	}
	public void setDoj(String doj) {
		this.DOJ = doj;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	


	


}
