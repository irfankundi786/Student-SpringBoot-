package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.StudentAlreadyExistsException;
import com.student.exception.StudentNotFoundException;
import com.student.model.Student;
import com.student.repository.StudentRepository;


@Service

public class StudentService {
	@Autowired
	private StudentRepository studentrepository;

	// get all students

	public List<Student> getAllStudents() {
		return studentrepository.findAll();
	}
	//get student by id
	public Student getStudentById(Long id)
	{
		return studentrepository.findById(id)
				.orElseThrow(()->new StudentNotFoundException("Sorry, no student found with the Id  " +id));
	}
	//delete the student
	 public void deleteStudent(Long id) {
	        if (!studentrepository.existsById(id)){
	            throw new StudentNotFoundException("Sorry, student not found");
	        }
	        studentrepository.deleteById(id);
	    }
	//Save Student in database
	public Student addStudent(Student student)
	{
		if (studentAlreadyExists(student.getEmail() )){
            throw  new StudentAlreadyExistsException(student.getEmail()+ " already exists!");
        }
		
		return studentrepository.save(student);
	}
	private boolean studentAlreadyExists(String email) {
        return studentrepository.findByEmail(email).isPresent();
    }
	//update the student
	public Student updateStudent(Student student,Long id)
	{
		Student st = studentrepository.findById(id)
				.orElseThrow(()->new StudentNotFoundException("Student not exit for this id:"+ id));
	st.setFirstName(student.getFirstName());	
	st.setDepartment(student.getDepartment());
	st.setEmail(student.getEmail());
	st.setLastName(student.getLastName());
	studentrepository.save(st);
	return st;
	}
	
	

}
