package com.enterjavafullstack.springbootdemo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterjavafullstack.springbootdemo.model.Student;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {
	List<Student> findByFirstName(String fname, Sort sort);
	List<Student> findByFirstNameAndLastName(String fname, String lname);
	List<Student> findByFirstNameOrLastName(String fname, String lname);
	List<Student> findByOrderByTotalDesc();
	
	
}
