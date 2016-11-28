package com.seyma.springmvc.controller;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.seyma.springmvc.controller.ContactsRestURIConstants;
import com.seyma.springmvc.model.Contact;
import com.seyma.springmvc.objects.ContactInput;
import com.seyma.springmvc.objects.ContactOutput;
import com.seyma.springmvc.model.Phone;
import com.seyma.springmvc.service.ContactService;
import com.seyma.springmvc.service.PhoneService;
 
@Controller
public class AppController {
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
    ContactService service;
	
	@Autowired
    PhoneService pService;
     
	
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing contacts.
     */
    @RequestMapping(value = ContactsRestURIConstants.GET_CONTACTS, method = RequestMethod.GET, produces = "application/json")  
    public @ResponseBody String listContacts(@PathVariable("name") String name) {
    	//String result = null;
    	List<ContactOutput> result= new ArrayList<ContactOutput>();
        List<Contact> contacts = service.findByName(name);
        int count=contacts.size();
        
        for(int i=0; i<count ;i++)
        {
        	Contact cTemp=contacts.get(i);
        	ContactOutput cOut=new ContactOutput();
        	cOut.set_name(cTemp.getName());
        	cOut.set_lastname(cTemp.getLastName());
        	cOut.set_phones(pService.findByContactId(cTemp.getId()));
        	result.add(cOut);
        }
        Gson gson = new Gson();
        //model.addAttribute("contact", contacts);
       // result = gson.toJson(contacts);
        return gson.toJson(result);
    }
 
   
    /*
     * This method will be called on form submission, handling POST request for
     * saving contact in database. It also validates the user input
     */
    @RequestMapping(value = ContactsRestURIConstants.IMPORT_CONTACTS, method = RequestMethod.POST)
    @Consumes({ MediaType.APPLICATION_JSON })
    public String importContacts(@RequestBody String json) throws JsonParseException, JsonMappingException, IOException {
    	List<ContactInput> importData =  Arrays.asList(mapper.readValue(json, ContactInput[].class));
        int count = importData.size();
    	for (int i=0; i < count;i++)
    	{
    		String name=importData.get(i).name;
    		String lastName=importData.get(i).lastName;
    		String phoneNumber=importData.get(i).phone;
    		//if contact is not added before
    		if(service.isContactUnique(name, lastName))
    		{
    			Contact contact= new Contact();
    			contact.setName(name);
    			contact.setLastName(lastName);
    			service.saveContact(contact);
    			
    			Phone phone = new Phone();
    			phone.setPhoneNumber(phoneNumber);
    			phone.setContactId(contact.getId());
    			pService.savePhone(phone);
    		
    		}
    		else
    		{
    			Contact c=service.findByNameAndLastName(name, lastName);
    			//if contact is already added but phone number is different
    			if(pService.isPhoneNumberNotAddedForContact(c.getId(), phoneNumber))
    			{
    				Phone phone = new Phone();
        			phone.setPhoneNumber(phoneNumber);
        			phone.setContactId(c.getId());
        			pService.savePhone(phone);
    			}
    			else
    			{
    				//duplicate record
    			}
    		}
    	}
 
       
        return "success";
    }
 
 
 
     
 
}