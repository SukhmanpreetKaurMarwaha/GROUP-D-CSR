package com.signify.exception;

public class StudentAddCourseException extends Exception {

	public StudentAddCourseException() {
		System.out.println("\nCOURSE ALREADY PRESENT OR COURSE NOT PRESENT IN CATALOG\n");
	}
}
