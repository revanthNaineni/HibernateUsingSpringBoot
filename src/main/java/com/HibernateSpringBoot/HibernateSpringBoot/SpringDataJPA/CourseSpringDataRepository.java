package com.HibernateSpringBoot.HibernateSpringBoot.SpringDataJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.HibernateSpringBoot.HibernateSpringBoot.entities.Course;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}
