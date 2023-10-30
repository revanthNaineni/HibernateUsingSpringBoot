package com.HibernateSpringBoot.HibernateSpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rating;
	private String description;
	
	@ManyToOne
	private Course course;

	public Review() {
	}

	public Review(Long id, String description, String rating) {
		super();
		this.id = id;
		this.rating = rating;
		this.description = description;
	}
	
	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}

}
