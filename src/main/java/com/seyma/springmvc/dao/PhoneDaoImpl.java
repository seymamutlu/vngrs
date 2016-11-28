package com.seyma.springmvc.dao;
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.seyma.springmvc.model.Phone;
 
//Implementation of Data Access Layer for Phone
@Repository("PhoneDao")
public class PhoneDaoImpl extends AbstractDao<Integer, Phone> implements PhoneDao {
 
	//Lists all the phone numbers of a contact
    @SuppressWarnings("unchecked")
	public List<String> findByContactId(int contactId) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("contactId", contactId));			//add an "equal" restriction on criteria
        criteria.setProjection(Projections.property("phoneNumber"));	//selects the column that contains phone numbers
        List<String> result =criteria.list();
        return result;
    }
 
    //Finds if that phone number is already added for that contact
    public Phone findByContactIdAndPhoneNumber(int contactId,String phoneNumber) {
    	Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("contactId", contactId));			//add an "equal" restriction on criteria
        criteria.add(Restrictions.eq("phoneNumber", phoneNumber));		//add an "equal" restriction on criteria
        return (Phone) criteria.uniqueResult();
    }
 
    //Saves a phone number to database
    public void savePhone(Phone phone) {
        	save(phone);
    }
 
    
    
}