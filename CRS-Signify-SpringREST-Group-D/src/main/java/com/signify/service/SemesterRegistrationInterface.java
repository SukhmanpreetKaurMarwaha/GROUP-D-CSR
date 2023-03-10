/**
 * 
 */
package com.signify.service;

import java.util.List;

/**
 * @author HP
 *
 */
public interface SemesterRegistrationInterface {
	public void registerCourse(int studentId,int semester);
	public void addCourse(String courseCode);
	public void dropCourse(String courseCode,int studentId);
	public void payFees(int studentId,String corseCode);
	public List<String> viewRegisteredCourse(int studentId,int semester);

}
