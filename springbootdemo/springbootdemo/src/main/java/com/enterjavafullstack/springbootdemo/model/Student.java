package com.enterjavafullstack.springbootdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "telugu")
	private int telugu;
	@Column(name = "hindi")
	private int hindi;
	@Column(name = "english")
	private int english;
	@Column(name = "maths")
	private int maths;
	@Column(name = "science")
	private int science;
	@Column(name = "social")
	private int social;
	@Column(name = "total")
	private int total;

	public Student() {

	}

	public Student(String firstName,String lastName, int telugu, int hindi, int english, int maths, int science, int social,
			int total) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telugu = telugu;
		this.hindi = hindi;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.social = social;
		this.total = telugu+hindi+english+maths+science+social;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTelugu() {
		return telugu;
	}

	public void setTelugu(int telugu) {
		this.telugu = telugu;
	}

	public int getHindi() {
		return hindi;
	}

	public void setHindi(int hindi) {
		this.hindi = hindi;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getTotal() {
		return telugu+hindi+english+maths+science+social;
	}

	public void setTotal(int total) {
		this.total = telugu+hindi+english+maths+science+social;
	}


}