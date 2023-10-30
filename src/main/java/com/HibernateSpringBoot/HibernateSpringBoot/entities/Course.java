package com.HibernateSpringBoot.HibernateSpringBoot.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "course")
	private List<Review> reviews;

	@CreationTimestamp
	private LocalDateTime createdDate;
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public Course() {
	}

	public Course(int id, String name, LocalDateTime createdDate, LocalDateTime lastUpdateDate) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Course(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}

}
