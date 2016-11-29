package com.seyma.springmvc.service;
 
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
 
import java.util.ArrayList;
import java.util.List;
 
import static org.mockito.Mockito.when;
 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seyma.springmvc.model.Contact;
import com.seyma.springmvc.dao.ContactDao;
 
public class ContactServiceImplTest {
 
    @Mock
    ContactDao dao;
     
    @InjectMocks
    ContactServiceImpl contactService;
     
    @Spy
    List<Contact> contacts = new ArrayList<Contact>();
     
    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        contacts = getContactList();
    }
 
    @Test
    public void findById(){
    	Contact cnt = contacts.get(0);
        when(dao.findById(anyInt())).thenReturn(cnt);
        Assert.assertEquals(contactService.findById(cnt.getId()),cnt);
    }
 
    @Test
    public void findByNameAndLastName(){
    	Contact cnt = contacts.get(0);
        when(dao.findByNameAndLastName(anyString(),anyString())).thenReturn(cnt);
        Assert.assertEquals(contactService.findByNameAndLastName(cnt.getName(), cnt.getLastName()), cnt);
    }
    
    @Test
    public void saveContact(){
        doNothing().when(dao).saveContact(any(Contact.class));
        contactService.saveContact(any(Contact.class));
        verify(dao, atLeastOnce()).saveContact(any(Contact.class));
    }
    
    @Test
    public void findByName(){
    	List<Contact> cnt = contacts.subList(0, 1);
        when(dao.findByName(anyString())).thenReturn(cnt);
        Assert.assertEquals(contactService.findByName(cnt.get(0).getName()),cnt);
    }
 
 
    @Test
    public void isContactUnique(){
        Contact cnt = contacts.get(0);
        when(dao.findByNameAndLastName(anyString(),anyString())).thenReturn(cnt);
        Assert.assertEquals(contactService.isContactUnique(cnt.getName(), cnt.getLastName()), false);
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
     
}