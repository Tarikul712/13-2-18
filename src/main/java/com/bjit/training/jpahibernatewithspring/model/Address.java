package com.bjit.training.jpahibernatewithspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "state")
	private String state;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@Column(name="zip_code")
	private int zipCode;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	public Address() {
	}

	public Address(String state, String city, String country, int zipCode) {
		super();
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	

	public Address(String state, String city, String country, int zipCode, Person person) {
		super();
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String print(){
		return "City:"+city+" State:"+state+" Zip Code:"+zipCode;
	}
	
}