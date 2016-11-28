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

import com.seyma.springmvc.model.Phone;
import com.seyma.springmvc.dao.PhoneDao;
 
public class PhoneServiceImplTest {
 
    @Mock
    PhoneDao dao;
     
    @InjectMocks
    PhoneServiceImpl phoneService;
     
    @Spy
    List<Phone> phones = new ArrayList<Phone>();
     
    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        phones = listPhones();
    }
 
   
    @Test
    public void findByContactIdAndPhoneNumber(){
    	Phone cnt = phones.get(0);
        when(dao.findByContactIdAndPhoneNumber(anyInt(),anyString())).thenReturn(cnt);
        Assert.assertEquals(phoneService.findByContactIdAndPhoneNumber(cnt.getContactId(), cnt.getPhoneNumber()), cnt);
    }
    
    @Test
    public void saveContact(){
        doNothing().when(dao).savePhone(any(Phone.class));
        phoneService.savePhone(any(Phone.class));
        verify(dao, atLeastOnce()).savePhone(any(Phone.class));
    }
    
    @Test
    public void findByContactId(){
    	List<String>cnt =new ArrayList<String>();
    	cnt.add(phones.get(0).getPhoneNumber());
    	cnt.add(phones.get(1).getPhoneNumber());
        when(dao.findByContactId(anyInt())).thenReturn(cnt);
        Assert.assertEquals(phoneService.findByContactId(1),cnt);
    }
 
 
    @Test
    public void isPhoneNumberNotAddedForContact(){
        Phone cnt = phones.get(0);
        when(dao.findByContactIdAndPhoneNumber(anyInt(),anyString())).thenReturn(cnt);
        Assert.assertEquals(phoneService.isPhoneNumberNotAddedForContact(cnt.getContactId(), cnt.getPhoneNumber()), true);
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