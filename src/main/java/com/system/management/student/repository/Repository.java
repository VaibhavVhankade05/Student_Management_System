package com.system.management.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.management.student.entity.Student;

public interface Repository extends JpaRepository<Student, Integer>
{

}
