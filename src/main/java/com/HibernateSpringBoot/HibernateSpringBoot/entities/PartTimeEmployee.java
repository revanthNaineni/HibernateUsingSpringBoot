package com.HibernateSpringBoot.HibernateSpringBoot.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{
	
	private BigDecimal hourlyWage;
	
	public PartTimeEmployee() {
	}

	public PartTimeEmployee(String name,BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	
	
	
	
	

}
