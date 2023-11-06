package com.HibernateSpringBoot.HibernateSpringBoot;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.HibernateSpringBoot.HibernateSpringBoot.JPADAO.EmployeeRepository;
import com.HibernateSpringBoot.HibernateSpringBoot.JPADAO.PersonJpaDAO;
import com.HibernateSpringBoot.HibernateSpringBoot.JPADAO.StudentRepository;
import com.HibernateSpringBoot.HibernateSpringBoot.entities.FullTimeEmployee;
import com.HibernateSpringBoot.HibernateSpringBoot.entities.PartTimeEmployee;
import com.HibernateSpringBoot.HibernateSpringBoot.entities.Person;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class HibernateSpringBootApplication implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaDAO personJpaDAO;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRelated();
		//studentRelated();
		//employeeRelated();

	} 	 	

	//personRelated
	private void personRelated() {
		/*
		 * JDBCTemplate log.info("All users -> {}" + personJdbcDAO.findAll());
		 * log.info("One user -> {}" + personJdbcDAO.findById(1));
		 * log.info("One user deleted with id : " + personJdbcDAO.deleteById(1));
		 * log.info("inserting some data " + personJdbcDAO.insertPerson(new Person(5,
		 * "Modrich", "Crotia", new Date()))); log.info("updating an id " +
		 * personJdbcDAO.updatePerson(new Person(2, "Ousmane", "Paris", new Date())));
		 */
		
		log.info("All users -> {}" + personJpaDAO.findById(1));

		
		  Person person1=new Person("Haaland", "Man City",new Date());
		  log.info("Inserted user1 -> {}" + personJpaDAO.insertPerson(person1));
		  
		  Person person2=new Person("Dembele", "PSG",new Date());
		  log.info("Inserted user2 -> {}" + personJpaDAO.insertPerson(person2));
		  
		  Person person3=new Person("Reus", "Dortmund",new Date());
		  log.info("Inserted user3 -> {}" + personJpaDAO.insertPerson(person3));
		 
		
		/*
		 * Person person1=new Person(10,"Erling Haaland", "Man City ",new Date());
		 * personJpaDAO.persistPerson(person1);
		 */
		
		personJpaDAO.persistPerson();

		Person person = personJpaDAO.findById(1);
		person.setName("Naineni Revanth");
		log.info("Updated user -> {}" + personJpaDAO.updatePerson(person));

		//personJpaDAO.deletePerson(2);

		log.info("All users -> " + personJpaDAO.findAll());
		
		personJpaDAO.findAllNames();
		personJpaDAO.findAllNamesStartsWithLetter();
		personJpaDAO.findAllPersonsWhoseLocationisEqualsTo();
		personJpaDAO.findByIdFirst_Level_Cache();
		personJpaDAO.findByIdFirst_Level_Cache2();
	}
	//studentRelated
	public void studentRelated() {
		studentRepository.saveStudentWithPassport();
		studentRepository.fetchStudentWithPassport();
		studentRepository.fetchPassportWithStudent();
		studentRepository.saveCourse();
		studentRepository.addReviewForCourse();
		studentRepository.retrieveReviewsforCourse();
		studentRepository.retrieveCourseforReview();
		studentRepository.saveStudent();
		studentRepository.registerStudentwithCourse();
		studentRepository.retrieveStudentwithCourse();
		studentRepository.jpql_CoursesWithZeroStudents();
		studentRepository.jpql_CoursesWithAtleast2Students();
		studentRepository.jpql_CoursesWithStudents_OrderedBy();
		studentRepository.jpql_CoursesWithStudents_like();
		studentRepository.jpql_join();
		
	}
	
	//employeeRelated
	public void employeeRelated() {
		
		employeeRepository.insertEmployee(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		employeeRepository.insertEmployee(new PartTimeEmployee("John", new BigDecimal(50)));
		//System.out.println("Retrieved Employees : "+employeeRepository.retrieveEmployees());
		System.out.println("Retrieved Full Time Employees : "+employeeRepository.retrieveFullTimeEmployees());
		System.out.println("Retrieved Part Time Employees : "+employeeRepository.retrievePartTimeEmployees());
		
	}

}
