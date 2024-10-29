package com.system.management.student.service;

import java.util.List;

import com.system.management.student.entity.Student;


public interface Service 
{
	
	List<Student> getAllStudent();
	
	Student getStudentById(Integer id);
	
	Student createStudent(Student student);
	
	Student updateStudent(Integer id, Student student);
	
	void deleteById(Integer id);

	List<Student> addMultipleStudents(List<Student> students);

	
}
