package com.seyma.springmvc.dao;
 
import java.util.List;

import com.seyma.springmvc.model.Contact;

//Interface of Data Access Layer for Domain Model Contact for mapping an object object oriented domain model to a traditional database
public interface ContactDao {
 
	//Finds the contact by Id
    Contact findById(int id);
 
    //Saves contact to database
    void saveContact(Contact contact);

    //Lists the contacts with the given name
	List<Contact> findByName(String name);

	//Finds if there is already a contact in the database with the given name and lastname
	Contact findByNameAndLastName(String name, String lastName);
 
}