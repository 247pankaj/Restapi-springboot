package com.pankaj.restapidemo.service;

import java.util.List;

import com.pankaj.restapidemo.model.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student addStudent(Student newStudent);

	Student getStudentById(Long id);

	Student updateStudentDetails(Student newStudent, Long id);

	void deleteStudent(Long id);
}
