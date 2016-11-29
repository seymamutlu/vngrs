package com.seyma.springmvc.controller;
 
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;
 
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.seyma.springmvc.model.Contact;
import com.seyma.springmvc.service.ContactService;
import com.seyma.springmvc.model.Phone;
import com.seyma.springmvc.service.PhoneService;
 
public class AppControllerTest {
 
    @Mock
    ContactService service;
   
    @Mock
    PhoneService pService;
     
    @Mock
    MessageSource message;
     
    @InjectMocks
    AppController appController;
     
    @Spy
    List<Contact> contacts = new ArrayList<Contact>();
    
    @Spy
    List<Phone> phones = new ArrayList<Phone>();
 
    @Spy
    ModelMap model;
     
    @Mock
    BindingResult result;
     
    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        contacts = getContactList();
        phones = listPhones();
        
    }
     
    @Test
    public void listContacts(){
        when(service.findByName("Seyma")).thenReturn(contacts.subList(0, 1));
        Assert.assertEquals(appController.listContacts(model.toString()), "allcontacts");
        Assert.assertEquals(model.get("contacts"), contacts);
        verify(service, atLeastOnce()).findByName(anyString());
    }
 
 
  
 
    public List<Contact> getContactList(){
        Contact c1 = new Contact();
        c1.setId(1);
        c1.setName("Seyma");
        c1.setLastName("Mutlu");
       
         
        Contact c2 = new Contact();
        c2.setId(2);
        c2.setName("Seyma");
        c2.setLastName("Subasý");
        
        Contact c3 = new Contact();
        c3.setId(3);
        c3.setName("Sehnaz");
        c3.setLastName("Efe");
         
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        return contacts;
    }
    
    public List<Phone> listPhones(){
    	Phone p1 = new Phone();
        p1.setContactId(1);
        p1.setPhoneNumber("+90 5322233566");
        
        Phone p2 = new Phone();
        p2.setContactId(1);
        p2.setPhoneNumber("+90 5315454555");
        
        Phone p3 = new Phone();
        p3.setContactId(3);
        p3.setPhoneNumber("+90 5413454545");
        
        Phone p4 = new Phone();
        p4.setContactId(2);
        p4.setPhoneNumber("+90 5413454545");
         
         
        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        phones.add(p4);
        return phones;
    }
}