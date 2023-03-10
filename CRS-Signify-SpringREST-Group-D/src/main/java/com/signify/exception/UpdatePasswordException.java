package com.signify.exception;
//Exception used in StudentDAOImplementation in function update_pass()

public class UpdatePasswordException extends Exception{

	public UpdatePasswordException()
	{
		System.out.println("Password Cannot be Updated");
	}
}
