package com.signify.service;

import java.util.List;

import com.signify.bean.Grade;
import com.signify.bean.Student;
import com.signify.exception.StudentDBViewException;
import com.signify.exception.ViewEnrolledStudentsException;

public interface ProfessorInterface {
	public List<Student> viewEnrolledStudents(int pid);
	public boolean add_Grade(Grade grade) ;
}
