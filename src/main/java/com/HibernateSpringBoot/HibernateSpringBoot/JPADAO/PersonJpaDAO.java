package com.HibernateSpringBoot.HibernateSpringBoot.JPADAO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateSpringBoot.HibernateSpringBoot.entities.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	//JPQL
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	//JPQL
	public void findAllNames() {
		List<Person> resultList = entityManager.createQuery("select p.name from Person p",Person.class).getResultList();
		System.out.println("findAllNames "+resultList);
	}
	
	//JPQL
	public void findAllNamesStartsWithLetter() {
		List<Person> resultList = entityManager.createQuery("select p.name from Person p where p.name like 'N%'",Person.class).getResultList();
		System.out.println("findAllNamesStartsWithLetter "+resultList);
	}
	
	public void findAllPersonsWhoseLocationisEqualsTo() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons_where_location_equals_to",Person.class);
		namedQuery.setParameter("location", "Shayampet");
		List<Person> resultList = namedQuery.getResultList();
		System.out.println("findAllNamesStartsWithLetter "+resultList);
	}
	
	public Person insertPerson(Person person) {
		return entityManager.merge(person);
	}
	
	public void persistPerson() {
		
		Person person2=new Person("Sane", "Munich", new Date());
		entityManager.persist(person2);
		
		entityManager.flush();
		person2.setLocation("Bayern Kane");
		//entityManager.flush();
		//entityManager.detach(person2);
		//person2.setLocation("Bayern Munich");
		//entityManager.clear();
		entityManager.refresh(person2);
		entityManager.flush();
		 
	}
	  
	
	public Person updatePerson(Person person) {
		return entityManager.merge(person);
	}
	
	/*
	 * public Person updatePerson2(Person person) { return
	 * entityManager.merge(person); }
	 */
	
	public void deletePerson(int id) {
		Person person = findById(id);
		if (person != null) {
			entityManager.remove(person);
		}
	}

}
