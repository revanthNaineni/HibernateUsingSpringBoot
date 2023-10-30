package com.HibernateSpringBoot.HibernateSpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
	private Student student;

	public Passport() {
	}
	
	public Passport(String number) {
		this.number = number;
	}

	public Passport(Long id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}

}
