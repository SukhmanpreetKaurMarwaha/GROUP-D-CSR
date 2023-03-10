/**
 * 
 */
package com.signify.constants;

/**
 * @author HP
 *
 */
public class SQLConstants {
	
	
	// Stsudent Constants 
	
	public static final String REGISTER_STUDENT="insert into student values(?,?,?,?,?)";
    public static final String STUDENT_DB_VIEW="SELECT * FROM student";
    public static final String UPDATE_PASS="update users set Password=? where Userid=?";
    public static final String SEARCH_PASS="select * from users where Userid=? ";
	
    public static final String VIEW_UNAPPROVED_STUDENTS="SELECT * FROM student where status = 'yet_to_approve'";
    public static final String STUDENT_LOGIN_SEARCH="SELECT * FROM student where studentid=?";
    public static final String STUDENT_LOGIN="SELECT * FROM users where Userid=? AND Password=? ";
    public static final String SEARCH_COURSE_INFO="SELECT courseid,course_price FROM course_info";
    public static final String ADD_STD_COURSE="insert into ref_studentcourse values(?,?,?)";
    public static final String STD_DROP_COURSE="delete from ref_studentcourse where courseid=? and studentid=?";
    public static final String COURSE_PAYMENT="Select course_price from ref_studentcourse where studentid=?";
    public static final String ADD_PAYMENT_IN_TABLE="insert into payment values(?,?,?,?)";
    public static final String SEARCH_DO_COURSE_PAYMENT="select * from payment where Studentid=?";
    public static final String DO_COURSE_PAYMENT="update payment set Mode_of_payment=?, Status=? where Studentid=?";
    public static final String VIEW_GRADE_CARD="Select * from grade_info where std_id=?";
    //public static final String UPDATE_STATUS="update payment "
    
    
    		// professors constants 
    public static final String PROFESSOR_DB_CREATE="insert into prof_g values(?,?,?,?)";
    public static final String ADD_GRADE="insert into grade_info values(?,?,?,?)";
    public static final String CREATE_USER="insert into users values(?,?,?,?)";
    public static final String SEARCH_COURSE_INFO_viewEnrolledStudents="SELECT * FROM course_info WHERE profid=?";
    public static final String SEARCH_STUDENTID_viewEnrolledStudents="SELECT studentid FROM ref_studentcourse WHERE courseid=?";
    public static final String VIEW_ENROLLED_STUDENTS= "SELECT * FROM student WHERE studentid=?";
    public static final String SEARCH_STUDENT_WITH_COURSE="select courseid from ref_studentcourse where studentid=?";
	
	// Admin Constants 
    public static final String ADMIN_DB_CREATE="insert into admin values(?,?,?)";
    public static final String APPROVE_STD_SEARCH ="select status from student where studentid=?";
    public static final String UPDATE_STD_APPROVE="update student set status=? where studentid=?";
    public static final String ADD_COURSE_CATALOG="insert into course_info values(?,?,?,?)";
    public static final String DELETE_COURSE_CATALOG="delete from course_info where courseid=?";
    public static final String COURSE_DETAILS="SELECT * FROM course_info";//where courseid=?
    
    //user constants
    public static final String LOGIN="SELECT * FROM users where Userid=? AND Password=?";

}
