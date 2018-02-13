package com.bjit.training.jpahibernatewithspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjit.training.jpahibernatewithspring.dao.PersonDao;
import com.bjit.training.jpahibernatewithspring.model.Person;

@Service
public class PersonServiceImp implements PersonService {
	@Autowired
	private PersonDao userDao;

	@Transactional
	public void add(Person person) {
		userDao.add(person);
	}

	@Transactional(readOnly = true)
	public List<Person> listPersons() {
		return userDao.listPersons();
	}
	
	@Transactional(readOnly = true)
	public Person getOne(Long id) {
		return userDao.getOne(id);
	}

	@Transactional
	public Person update(Person person) {
		
		return userDao.update(person);
	}
	@Transactional
	public void delete(Long id) {
		userDao.delete(id);
	}
}