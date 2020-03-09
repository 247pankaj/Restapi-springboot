package com.pankaj.restapidemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.restapidemo.exception.RecordNotFoundException;
import com.pankaj.restapidemo.model.Student;
import com.pankaj.restapidemo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) repository.findAll();
	}

	@Override
	public Student addStudent(Student newStudent) {
		return repository.save(newStudent);
	}

	@Override
	public Student getStudentById(Long id) {

		return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
	}

	@Override
	public Student updateStudentDetails(Student newStudent, Long id) {
		return repository.findById(id).map(student -> {
			student.setStudentname(newStudent.getStudentname());
			student.setEmail(newStudent.getEmail());
			return repository.save(student);
		}).orElseGet(() -> {
			newStudent.setId(id);
			return repository.save(newStudent);
		});
	}

	@Override
	public void deleteStudent(Long id) {

		repository.deleteById(id);
	}

}
