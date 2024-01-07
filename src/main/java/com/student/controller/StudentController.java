package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;
@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentservice;

	// get all employee
	@GetMapping
	public List<Student> getAllStudents() {
		return studentservice.getAllStudents();
	}

	// Get Single student by id
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentservice.getStudentById(id);
	}

	// Save the student
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentservice.addStudent(student);

	}

	// delete the student
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable Long id) {
		System.out.println("delete is calling");
		studentservice.deleteStudent(id);
	}

	// update the student
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
		return studentservice.updateStudent(student, id);
	}
}
