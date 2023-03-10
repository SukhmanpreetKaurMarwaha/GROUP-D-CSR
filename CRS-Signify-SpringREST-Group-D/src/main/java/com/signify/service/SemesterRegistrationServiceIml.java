/**
 * 
 */
package com.signify.service;
import java.util.*;

/**
 * @author Tejaswini.S.J
 *
 */
public class SemesterRegistrationServiceIml implements SemesterRegistrationInterface
{
        public void registerCourse(int studentId,int semester)
        {
        	System.out.println("course is registered");
        }
        public void addCourse(String courseCode)
        {
        	System.out.println("course added");
        }
        public void dropCourse(String courseCode,int studentId)
        {
        	System.out.println("course dropped");
        }
        public void payFees(int studentId,String corseCode)
        {
        	System.out.println("fees paid");
        }
        public List<String> viewRegisteredCourse(int studentId,int semester)
        {
        	System.out.println("registered course is visible");
        	List<String>l=new ArrayList<String>();
        	return l;
        }
}
