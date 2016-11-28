package com.seyma.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seyma.springmvc.dao.ContactDao;
import com.seyma.springmvc.model.Contact;


//Service Layer Implementation of operations on Contact model(contactnames datatable)

@Service("ContactService")
@Transactional
@Component
public class ContactServiceImpl implements ContactService {

	//Dependency injection on data access layer
	@Autowired
	private ContactDao dao;

	//Gets contact by its Id
	public Contact findById(int id) {
		return dao.findById(id);
	}

	//Lists the contacts with the given name
	public List<Contact> findByName(String name) {
		return dao.findByName(name);
	}

	//Finds if there is a contact added previously to the database with the given name and lastname
	public Contact findByNameAndLastName(String name, String lastName) {
		return dao.findByNameAndLastName(name, lastName);
	}

	//Saves contact to database
	public void saveContact(Contact contact) {
		dao.saveContact(contact);
	}


	//Checks if a given contact is already added to the database or not
	public boolean isContactUnique(String name, String lastName) {
		Contact contact = findByNameAndLastName(name, lastName);
		return (contact == null);
	}
}