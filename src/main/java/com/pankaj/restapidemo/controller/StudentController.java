package com.pankaj.restapidemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.restapidemo.model.Student;
import com.pankaj.restapidemo.service.StudentService;
import com.pankaj.restapidemo.util.Constants;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping
	ResponseEntity<List<Student>> getAllStudents() // @RequestParam(value = Constants.USER_ID) int userId
	{
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<Student> addStudent(@RequestBody Student newStudent) {
		return new ResponseEntity<>(studentService.addStudent(newStudent), HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<Student> getStudentById(@PathVariable Long id) {

		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<Student> updateStudentDetails(@RequestBody Student newStudent, @PathVariable Long id) {

		return new ResponseEntity<Student>(studentService.updateStudentDetails(newStudent, id),
				HttpStatus.RESET_CONTENT);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<>(Constants.DELETE_OPERATION.concat(String.valueOf(id)), HttpStatus.NO_CONTENT);
	}

}
