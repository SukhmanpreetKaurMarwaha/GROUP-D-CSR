/**
 * 
 */
package com.signify.bean;
import java.io.Serializable;
/**
 * @author Tejaswini.S.J
 *
 */
public class SemesterRegistration 
{
	private int studentId;
    private int semester;
    private String dateOfRegistration;
           public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
		
}
