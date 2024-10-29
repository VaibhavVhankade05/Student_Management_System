package com.system.management.student.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.system.management.student.entity.Student;
import com.system.management.student.repository.Repository;
import com.system.management.student.service.Service;


public class ServiceImplementation implements Service
{
	
	@Autowired
	private Repository repository;

	@Override
	public List<Student> getAllStudent() 
	{	
		return repository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) 
	{
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
	}

	@Override
	public Student createStudent(Student student) 
	{
		return repository.save(student);
	}

	@Override
	public Student updateStudent(Integer id, Student studentdetails) 
	{
		return repository.findById(id).map(student -> 
		{
			student.setName(studentdetails.getName());
			student.setEmail(studentdetails.getEmail());
			student.setContact_no(studentdetails.getContact_no());
			student.setPosition(studentdetails.getPosition());
			return repository.save(student);
		}).orElseThrow(() -> new RuntimeException("Student Not Found"));
	}

	@Override
	public void deleteById(Integer id) 
	{
		repository.deleteById(id);
	}

	@Override
	public List<Student> addMultipleStudents(List<Student> students) {
		return repository.saveAll(students);
	}
	

}
