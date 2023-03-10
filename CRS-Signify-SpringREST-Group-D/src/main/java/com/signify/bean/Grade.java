/**
 * 
 */
package com.signify.bean;

import org.springframework.stereotype.Component;

/**
 * @author HP
 *
 */
@Component
public class Grade {
	private int std_id;
	private int profid;
	private String Courseid;
	private String grade;
	
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public int getProfid() {
		return profid;
	}
	public void setProfid(int profid) {
		this.profid = profid;
	}
	public String getCourseid() {
		return Courseid;
	}
	public void setCourseid(String courseid) {
		Courseid = courseid;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
