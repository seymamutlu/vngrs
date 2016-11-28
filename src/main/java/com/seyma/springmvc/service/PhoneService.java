package com.seyma.springmvc.service;
 
import java.util.List;

import com.seyma.springmvc.model.Phone;
 
//Interface of operations on Phone at service layer


public interface PhoneService {
 
	//Finds if the given phone added for the given contact previously
    Phone findByContactIdAndPhoneNumber(int contactId,String phoneNumber);
    
	//Returns list of phone numbers of a contact
    List<String> findByContactId(int id);
    
    //Saves phone to database
    void savePhone(Phone phone);
     
    //Checks if a given phone numbers is already added to the database for the given contact
    boolean isPhoneNumberNotAddedForContact(int contactId,String phoneNumber);
     
}