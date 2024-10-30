package com.system.management.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.system.management.employee.entity.Employee;
import com.system.management.student.entity.Student;
import com.system.management.student.service.StudentService;
//import com.system.management.student.service.Service;

@RestController
@RequestMapping("/students")
public class StudentController 
{
	@Autowired
	private StudentService studentservice;
	
	@GetMapping
	public List<Student> getAllStudent()
	{
		return studentservice.getAllStudent();
	}
	
	
	@GetMapping("/{id}")
    public ResponseEntity<Student> getEmployeeById(@PathVariable Integer id) {
		return ResponseEntity.ok(studentservice.getStudentById(id));
    }
	
	@PostMapping
    public Student Student(@RequestBody Student student) {
        return studentservice.createStudent(student);
    }
	
	@PostMapping("/bulk")
    public ResponseEntity<List<Student>> createMultipleEmployees(@RequestBody List<Student> students) {
        List<Student> createdEmployees = studentservice.addMultipleStudents(students);
        return new ResponseEntity<>(createdEmployees, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDeatails)
	{
		return ResponseEntity.ok(studentservice.updateStudent(id, studentDeatails));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id)
	{
		studentservice.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	

}
