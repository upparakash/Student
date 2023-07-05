package com.enterjavafullstack.springbootdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enterjavafullstack.springbootdemo.exception.ResourceNotFoundException;
import com.enterjavafullstack.springbootdemo.model.Student;
import com.enterjavafullstack.springbootdemo.repository.StudentRespository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

	@Autowired
	private StudentRespository stdRepository;

	// get all employees
	@GetMapping("/students")
	public List<Student> getAllStudent() {
		return stdRepository.findAll();
	}

	// create employee rest api
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student students) {
		students.setTotal(students.getTelugu()+students.getHindi()+students.getEnglish()+students.getMaths()+students.getScience()+students.getSocial());
		return stdRepository.save(students);
	}

	// get employee by id rest api
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student students = stdRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		return ResponseEntity.ok(students);
	}

	// update employee rest api

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		Student students = stdRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		students.setFirstName(studentDetails.getFirstName());
		students.setLastName(studentDetails.getLastName());
		students.setTelugu(studentDetails.getTelugu());
		students.setHindi(studentDetails.getHindi());
		students.setEnglish(studentDetails.getEnglish());
		students.setMaths(studentDetails.getMaths());
		students.setScience(studentDetails.getScience());
		students.setSocial(studentDetails.getSocial());
		students.setTotal(studentDetails.getTotal());

		Student updatedStudent = stdRepository.save(students);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@GetMapping("/student/{fname}")
	public ResponseEntity<List<Student>> getStudentByFirstName(@PathVariable String fname) {
		List<Student> students = stdRepository.findByFirstName(fname, Sort.by("total"));
		
		return ResponseEntity.ok(students);
	}
	
	
	
	@GetMapping("/studentdesc")
	public ResponseEntity<List<Student>> getStudentByTotalDesc() {
		List<Student> students=stdRepository.findByOrderByTotalDesc();
		return ResponseEntity.ok(students);
	}
	
	
	
	
	@GetMapping("/studentfl")
	public ResponseEntity<List<Student>> getStudentByFirstNameAndLastName(@RequestParam String fname, @RequestParam String lname) {
		List<Student> students = stdRepository.findByFirstNameAndLastName(fname,lname);
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/studentforl")
	public ResponseEntity<List<Student>> getStudentByFirstNameOrLastName(@RequestParam String fname, @RequestParam String lname) {
		List<Student> students = stdRepository.findByFirstNameOrLastName(fname,lname);
		return ResponseEntity.ok(students);
	}
	
	
	// delete employee rest api
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
		Student students = stdRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

		stdRepository.delete(students);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}