package com.signify.exception;
//Exception used in StudentDAOImplementation in function view_unapproved_stds()

public class ViewUnapprovedStudentsException extends Exception{

	public ViewUnapprovedStudentsException()
	{
		System.out.println("No Unapproved Student Available");
	}
}
