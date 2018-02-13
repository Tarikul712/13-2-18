package com.bjit.training.jpahibernatewithspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bjit.training.jpahibernatewithspring.model.Address;
import com.bjit.training.jpahibernatewithspring.model.Person;

@Repository
public class PersonDaoImp implements PersonDao {
	@PersistenceContext
	private EntityManager em;

	public void add(Person person) {
		em.persist(person);
	}

	public List<Person> listPersons() {
		CriteriaQuery<Person> criteriaQuery = em.getCriteriaBuilder().createQuery(Person.class);
		@SuppressWarnings("unused")
		Root<Person> root = criteriaQuery.from(Person.class);
		return em.createQuery(criteriaQuery).getResultList();
		//return null;
	}

	public Person getOne(Long id) {
		return em.find(Person.class, id);
	}

	public Person update(Person person) {
Person p = em.find(Person.class,person.getId());
		
		if (p != null) {
			p.setFirstName(person.getFirstName());
			p.setLastName(person.getLastName());
			p.setEmail(person.getEmail());
			
		}
		return p;
	}

	public void delete(Long id) {
		Person person = em.find(Person.class, id);
		if (person != null) {
			em.remove(person);
			System.out.println("Person deleted");
		}else
		System.out.println("Person not exists");
	}
}