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
public class Course {
	
	private String courseid;
	private String coursename;
	private int profid;
	private int course_price;
	
	
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getProfid() {
		return profid;
	}
	public void setProfid(int profid) {
		this.profid = profid;
	}
	public int getCourse_price() {
		return course_price;
	}
	public void setCourse_price(int course_price) {
		this.course_price = course_price;
	}
	
	
	
	

}
