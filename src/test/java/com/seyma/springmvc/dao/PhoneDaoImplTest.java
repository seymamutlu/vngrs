package com.seyma.springmvc.dao;
 
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import com.seyma.springmvc.model.Phone;
 
 
public class PhoneDaoImplTest extends AbstractDaoImplTest{
 
    @Autowired
    PhoneDao phoneDao;
 
    @Override
    protected IDataSet getDataSet() throws Exception{
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Phone.xml"));
        return dataSet;
    }
     
 
     
    @Test
    public void savePhone(){
        phoneDao.savePhone(getSamplePhone());
        Assert.assertEquals(phoneDao.findByContactId(909099).size(), 1);
    }
     
    
 
    @Test
    public void findByContactId(){
        Assert.assertEquals(phoneDao.findByContactId(5).size(), 1);
    }
     
    @Test
    public void findByContactIdAndPhoneNumber(){
    	Assert.assertEquals(phoneDao.findByContactIdAndPhoneNumber(6,"+90 543 3223332").getContactId(), 6);
    }
 
    public Phone getSamplePhone(){
        Phone phone = new Phone();
        phone.setContactId(909099);
        phone.setPhoneNumber("+90 5214232121");
        
        return phone;
    }
 
}