package com.seyma.springmvc.dao;
 
import java.util.List;

import com.seyma.springmvc.model.Phone;
 
//Interface of Data Access Layer for Domain Model Phone for mapping an object object oriented domain model to a traditional database
public interface PhoneDao {
 
	//Lists all the phone numbers of a contact
    List<String> findByContactId(int contactId);
 
    //Saves a phone number to database
    void savePhone(Phone phone);

    //Finds if that phone number is already added for that contact
	Phone findByContactIdAndPhoneNumber(int contactId,String phoneNumber);

 
}