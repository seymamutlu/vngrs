package com.seyma.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seyma.springmvc.dao.PhoneDao;
import com.seyma.springmvc.model.Phone;


//Service Layer Implementation of operations on Phone model(phonenumbers datatable)

@Service("PhoneService")
@Transactional
@Component
public class PhoneServiceImpl implements PhoneService {

	//Dependency injection on data access layer
	@Autowired			
	private PhoneDao dao;

	//Returns list of phone numbers of a contact
	public List<String> findByContactId(int id) {
		return dao.findByContactId(id);
	}


	//Saves phone to database
	public void savePhone(Phone phone) {
		dao.savePhone(phone);
	}
	
	//Finds if the given phone added for the given contact previously
	public Phone findByContactIdAndPhoneNumber(int contactId,String phoneNumber) {
			return dao.findByContactIdAndPhoneNumber(contactId,phoneNumber);
	}
	
    //Checks if a given phone numbers is already added to the database for the given contact
	public boolean isPhoneNumberNotAddedForContact(int contactId,String phoneNumber) {
		Phone phone = findByContactIdAndPhoneNumber(contactId,phoneNumber);
		return (phone == null);
	}

}