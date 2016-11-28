package com.seyma.springmvc.service;
 
import java.util.List;
 
import com.seyma.springmvc.model.Contact;
 

//Interface of operations on Contact at service layer

public interface ContactService {
 
	//Gets contact by its Id
    Contact findById(int id);
     
	//Lists the contacts with the given name
    List<Contact> findByName(String name);
    
	//Finds if there is a contact added previously to the database with the given name and lastname
    Contact findByNameAndLastName(String name, String lastName);
    
	//Saves contact to database
    void saveContact(Contact contact);
     
    //Checks if a given contact is already added to the database or not
    boolean isContactUnique(String name, String lastName); 		

     
}