package com.HibernateSpringBoot.HibernateSpringBoot.JPADAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateSpringBoot.HibernateSpringBoot.entities.Employee;
import com.HibernateSpringBoot.HibernateSpringBoot.entities.FullTimeEmployee;
import com.HibernateSpringBoot.HibernateSpringBoot.entities.PartTimeEmployee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.From;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
	
	@Autowired
	EntityManager entityManager;
	
	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	
	
	/*
	 * public List<Employee> retrieveEmployees(){ TypedQuery<Employee>
	 * createNamedQuery = entityManager.createQuery("select e From Employee e",
	 * Employee.class); return createNamedQuery.getResultList(); }
	 */
	 
	
	
	  public List<FullTimeEmployee> retrieveFullTimeEmployees(){
	  TypedQuery<FullTimeEmployee> createNamedQuery =
	  entityManager.createQuery("select e From FullTimeEmployee e",
	  FullTimeEmployee.class); return createNamedQuery.getResultList(); }
	  
	  public List<PartTimeEmployee> retrievePartTimeEmployees(){
	  TypedQuery<PartTimeEmployee> createNamedQuery =
	  entityManager.createQuery("select e From PartTimeEmployee e",
	  PartTimeEmployee.class); return createNamedQuery.getResultList(); }
	 
	

}
