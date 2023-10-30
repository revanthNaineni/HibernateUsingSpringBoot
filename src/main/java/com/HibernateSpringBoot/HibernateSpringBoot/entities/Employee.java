package com.HibernateSpringBoot.HibernateSpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Employee() {
	}

	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Employee(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
