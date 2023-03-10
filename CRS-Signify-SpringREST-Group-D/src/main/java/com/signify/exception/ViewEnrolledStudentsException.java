package com.signify.exception;
//Exception used in ProfessorDAOImplementation in function viewEnrolledStudents()
public class ViewEnrolledStudentsException extends Exception{

	public ViewEnrolledStudentsException()
	{
		System.out.println("Student not found");
	}
}
