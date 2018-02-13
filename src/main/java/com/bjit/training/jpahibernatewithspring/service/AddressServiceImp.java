package com.bjit.training.jpahibernatewithspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjit.training.jpahibernatewithspring.model.Address;
import com.bjit.training.jpahibernatewithspring.dao.AdderssDao;

@Service
public class AddressServiceImp implements AddressService {
	@Autowired
	private AdderssDao addressDao;;

	@Transactional
	public void add(Address address) {
		addressDao.add(address);
	}

	@Transactional(readOnly = true)
	public List<Address> listAddress() {
		return addressDao.listAddress();
	}
	
	@Transactional
	public void update(Address address) {
		// TODO Auto-generated method stub
		addressDao.update(address);
	}
	@Transactional
	public void delete(Address address) {
		addressDao.delete(address);
	}

	public Address getAddress(Long id) {
		// TODO Auto-generated method stub
		return addressDao.getAddress(id);
	}
}