package com.bjit.training.jpahibernatewithspring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bjit.training.jpahibernatewithspring.model.Address;
import com.bjit.training.jpahibernatewithspring.model.Person;
import com.bjit.training.jpahibernatewithspring.service.AddressService;
import com.bjit.training.jpahibernatewithspring.service.PersonService;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonService personService = context.getBean(PersonService.class);
		AddressService addressService = context.getBean(AddressService.class);
		
		// Add Persons
		Person p1 = new Person("Jhonddddd", "Due", "jhon.due@example.com");
		
		
		Address a1 = new Address("dhakaaaaaaaa","dha","Bangladeshgggggg",5244,p1);
		Address a2 = new Address("dhaka1","dha1","Bangladeshdddddddd1",52441,p1);
		Set<Address> addressList = new HashSet<Address>();
		addressList.add(a1);
		addressList.add(a2);
		
		p1.setAddresses(addressList);
		personService.add(p1);
		
		// Persons
		System.out.println("Person List:...........................");
		List<Person> persons = personService.listPersons();
		for (Person person : persons) {
			System.out.println(person.print());
			Set<Address> addresses = person.getAddresses();
			for (Address address : addresses) {
				System.out.println("Address [ "+address.print()+"]");
			}
		
			System.out.println();
		}
		
		//One person Info
		System.out.println("Get person Id 3:......................");
		Person p = personService.getOne(3L);
		System.out.println(p.print());
		Set<Address> addresses = p.getAddresses();
		for (Address address : addresses) {
			System.out.println("Address [ "+address.print()+"]");
		}
		
		//Delete Person
		System.out.println("\nDelete.......");
		personService.delete(7L);
		
		//Update person
		System.out.println("\nUpdate Info of Id 3:..........");
		p.setEmail("karim2@email.com");
		personService.update(p);
	
		
		context.close();
	}
}