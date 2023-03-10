package com.signify.exception;
//Exception used in CourseCatalogDAOImplementation class in function  catalog_db_create()
public class CourseCreateExceptions extends Exception {
	public CourseCreateExceptions() {
		System.out.println("COURSE ALREADY EXISTS");
	}

}
