package com.signify.exception;

public class UserCreateException extends Exception{

	public UserCreateException()
	{
		System.out.println("User Already Exists");
	}
}
