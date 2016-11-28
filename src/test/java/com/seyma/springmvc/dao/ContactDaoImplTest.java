package com.seyma.springmvc.dao;
 
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import com.seyma.springmvc.model.Contact;
 
 
public class ContactDaoImplTest extends AbstractDaoImplTest{
 
    @Autowired
    ContactDao contactDao;
 
    @Override
    protected IDataSet getDataSet() throws Exception{
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Contact.xml"));
        return dataSet;
    }
     
 
    @Test
    public void findById(){
        Assert.assertNotNull(contactDao.findById(1));
        Assert.assertNull(contactDao.findById(3));
    }
 
     
    @Test
    public void saveContact(){
        contactDao.saveContact(getSampleContact());
        Assert.assertEquals(contactDao.findByName("Melek").size(), 1);
    }
     
    
 
    @Test
    public void findByName(){
        Assert.assertEquals(contactDao.findByName("Melek").size(), 1);
    }
     
    @Test
    public void findByNameAndLastName(){
    	Assert.assertEquals(contactDao.findByNameAndLastName("Melek","Kara").getId(), 909099);
    }
 
    public Contact getSampleContact(){
        Contact contact = new Contact();
        contact.setId(909099);
        contact.setName("Melek");
        contact.setLastName("Kara");
        
        return contact;
    }
 
}