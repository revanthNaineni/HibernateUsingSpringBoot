package com.HibernateSpringBoot.HibernateSpringBoot.JPADAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateSpringBoot.HibernateSpringBoot.entities.Course;
import com.HibernateSpringBoot.HibernateSpringBoot.entities.Passport;
import com.HibernateSpringBoot.HibernateSpringBoot.entities.Review;
import com.HibernateSpringBoot.HibernateSpringBoot.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager entityManager;
	
	public void saveStudent() {
		Student student=new Student("Sehwag");
		entityManager.persist(student);
		Student student1=new Student("Sachin");
		entityManager.persist(student1);
		Student student3=new Student("Dravid");
		entityManager.persist(student3);
		Student student4=new Student("Kumble");
		entityManager.persist(student4);
	}
	
	public void saveStudentWithPassport() {
		Passport passport=new Passport("E12348");
		entityManager.persist(passport);
		Student student=new Student("Bhajji");
		student.setPassport(passport);
		entityManager.persist(student);
	}
	
	public void fetchStudentWithPassport() {
		Student student = entityManager.find(Student.class, 1);
		System.out.println(" Student "+student);
		System.out.println("passport "+student.getPassport());
	}

	public void fetchPassportWithStudent() {
		Passport passport = entityManager.find(Passport.class, 1);
		System.out.println("Passport "+passport);
		System.out.println("Student "+passport.getStudent());
	}
	
	public void saveCourse() {
		Course course1=new Course("Spring Boot");
		entityManager.persist(course1);
		Course course2=new Course("Hibernate");
		entityManager.persist(course2);
		Course course3=new Course("Java");
		entityManager.persist(course3);
	}
	
	public void addReviewForCourse() {
		Course course = entityManager.find(Course.class, 1);
		Review review1=new Review("5", "Nice Book");
		Review review2=new Review("3", "Avg Book");
		review1.setCourse(course);
		review2.setCourse(course);
		course.addReview(review1);
		course.addReview(review2);
		entityManager.persist(review1);
		entityManager.persist(review2);
	}
	
	public void retrieveReviewsforCourse() {
		Course course = entityManager.find(Course.class, 1);
		List<Review> reviews = course.getReviews();
		System.out.println("reviews : "+reviews);
	}
	
	public void retrieveCourseforReview() {
		Review review = entityManager.find(Review.class, 1);
		Course course = review.getCourse();
		System.out.println("reviews : "+course);
	}
	
	public void registerStudentwithCourse() {
		Student student = entityManager.find(Student.class, 1);
		Course course = entityManager.find(Course.class, 1);
		student.addCourses(course);
		entityManager.persist(student);
		Student student1 = entityManager.find(Student.class, 2);
		Course course1 = entityManager.find(Course.class, 2);
		student1.addCourses(course1);
		entityManager.persist(student1);
		Student student3 = entityManager.find(Student.class, 3);
		Course course2 = entityManager.find(Course.class, 2);
		student3.addCourses(course2);
		entityManager.persist(student3);
		
	}
	
	public void retrieveStudentwithCourse() {
		Student student = entityManager.find(Student.class, 1);
		System.out.println("Student's courses " + student.getCourses());
	}
	
	public void jpql_CoursesWithZeroStudents() {
		TypedQuery<Course> createQuery = entityManager.createQuery("SELECT c from Course c where c.students is empty",
				Course.class);
		System.out.println(createQuery.getResultList());
	}
	
	public void jpql_CoursesWithAtleast2Students() {
		TypedQuery<Course> createQuery = entityManager.createQuery("SELECT c from Course c where size(c.students) >=2",
				Course.class);
		System.out.println(createQuery.getResultList());
	}
	
	public void jpql_CoursesWithStudents_OrderedBy() {
		TypedQuery<Course> createQuery = entityManager.createQuery("SELECT c from Course c order by size(c.students)",
				Course.class);
		System.out.println(createQuery.getResultList());
	}
	
	public void jpql_CoursesWithStudents_like() {
		TypedQuery<Course> createQuery = entityManager.createQuery("SELECT c from Course c where c.name like '%Boot%'",
				Course.class);
		System.out.println(createQuery.getResultList());
	}
	
	public void jpql_join() {
		Query createQuery = entityManager.createQuery("SELECT c,s from Course c JOIN c.students s");
		System.out.println(createQuery.getResultList().size());
		List<Object[]> resultList = createQuery.getResultList();
		for (Object[] object : resultList) {
			System.out.println("Course "+object[0]);
			System.out.println("Student "+object[1]);
		}
	}
	
}
