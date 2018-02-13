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
public class AddressDaoImp implements AdderssDao {
	@PersistenceContext
	private EntityManager em;

	public void add(Address address) {
		em.persist(address);
	}

	public List<Address> listAddress() {
		CriteriaQuery<Address> criteriaQuery = em.getCriteriaBuilder().createQuery(Address.class);
		@SuppressWarnings("unused")
		Root<Address> root = criteriaQuery.from(Address.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	public Address getAddress(Long id) {
		Address address = em.find(Address.class, id);
		return address;
	}

	public void update(Address address) {
		//System.out.println("from update method"+address.getId());
		Address address2 = em.find(Address.class,address.getId());
		
		if (address2 != null) {
			address2.setCity(address.getCity());
			address2.setCountry(address.getCountry());
			address2.setPerson(address.getPerson());
			address2.setState(address.getState());
			address2.setZipCode(address.getZipCode());
		}
		
	}

	public void delete(Address address) {
		System.out.println("from delete method");
		Address address2 = em.find(Address.class, address.getId());
		if (address2 != null) {
			em.remove(address2);
		}

	}
}