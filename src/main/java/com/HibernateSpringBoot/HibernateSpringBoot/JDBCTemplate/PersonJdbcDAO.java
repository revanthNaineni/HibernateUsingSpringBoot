package com.HibernateSpringBoot.HibernateSpringBoot.JDBCTemplate;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.HibernateSpringBoot.HibernateSpringBoot.entities.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {

		List<Person> query = jdbcTemplate.query("Select * from person",
				new BeanPropertyRowMapper<Person>(Person.class));
		return query;

	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("Select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("Delete from Person where id=?", new Object[] { id });
	}

	public int insertPerson(Person person) {
		return jdbcTemplate.update(
				"INSERT INTO PERSON(id,name,location,birth_date) \r\n" + "VALUES (?,?,?,?);\r\n" + "",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}

	public int updatePerson(Person person) {
		return jdbcTemplate.update("UPDATE PERSON" + " SET name=? ,location=?,birth_date=?" + " where id=?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });
	}
}

