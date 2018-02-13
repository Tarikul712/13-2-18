package com.bjit.training.jpahibernatewithspring.dao;

import java.util.List;

import com.bjit.training.jpahibernatewithspring.model.Person;

public interface PersonDao {
	void add(Person person);
	List<Person> listPersons();
	Person getOne(Long id);
	Person update(Person person);
	void delete(Long id);
}
