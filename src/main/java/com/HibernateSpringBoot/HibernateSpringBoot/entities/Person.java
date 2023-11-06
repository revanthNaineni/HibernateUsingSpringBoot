package com.HibernateSpringBoot.HibernateSpringBoot.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSON1")
@NamedQueries(value = { @NamedQuery(name = "find_all_persons", query = "select p from Person p"),
		@NamedQuery(name = "find_all_persons_where_location_equals_to", query = "select p from Person p where p.location=:location") })
/*
 * @NamedQuery(name = "find_all_persons", query = "select p from Person p")
 * 
 * @NamedQuery(name = "find_all_persons_where_location_equals_to", query =
 * "select p from Person p where p.location=:location")
 */
@Cacheable
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	@Column(name = "birth_date")
	private Date birthDate;

	@CreationTimestamp
	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "lastUpdate_date")
	private LocalDateTime lastUpdateDate;

	public Person() {

	}

	public Person(int id, String name, String location, Date birthDate, LocalDateTime createdDate,
			LocalDateTime lastUpdateDate) {
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Person(String name, String location, Date birthDate) {
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate
				+ ", createdDate=" + createdDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

}
