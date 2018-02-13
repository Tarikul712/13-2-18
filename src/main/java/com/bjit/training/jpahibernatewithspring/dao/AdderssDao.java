package com.bjit.training.jpahibernatewithspring.dao;

import java.util.List;

import com.bjit.training.jpahibernatewithspring.model.Address;
import com.bjit.training.jpahibernatewithspring.model.Person;

public interface AdderssDao {
	void add(Address address);
	List<Address> listAddress();
	Address getAddress(Long id);
	void update(Address address);
	void delete(Address address);
}
