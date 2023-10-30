package com.HibernateSpringBoot.HibernateSpringBoot.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses;

	public Student() {

	}

	public Student(String name) {
		this.name = name;
	}

	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(Long id, String name, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course course) {
		this.courses.add(course);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}

}
