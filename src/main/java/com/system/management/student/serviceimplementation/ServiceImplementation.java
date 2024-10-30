package com.system.management.student.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.management.student.entity.Student;
//import com.system.management.student.repository.Repository;
import com.system.management.student.repository.StudentRepository;
//import com.system.management.student.service.Service;
import com.system.management.student.service.StudentService;


@Service
public class ServiceImplementation implements StudentService
{
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public List<Student> getAllStudent() 
	{	
		return studentrepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) 
	{
		return studentrepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
	}

	@Override
	public Student createStudent(Student student) 
	{
		return studentrepository.save(student);
	}

	@Override
	public Student updateStudent(Integer id, Student studentdetails) 
	{
		return studentrepository.findById(id).map(student -> 
		{
			student.setName(studentdetails.getName());
			student.setEmail(studentdetails.getEmail());
			student.setPosition(studentdetails.getPosition());
			student.setContact_no(studentdetails.getContact_no());
			return studentrepository.save(student);
		}).orElseThrow(() -> new RuntimeException("Student Not Found"));
	}

	@Override
	public void deleteById(Integer id) 
	{
		studentrepository.deleteById(id);
	}

	@Override
	public List<Student> addMultipleStudents(List<Student> students) {
		return studentrepository.saveAll(students);
	}
	

}
