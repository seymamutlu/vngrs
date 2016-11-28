package com.seyma.springmvc.dao;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.seyma.springmvc.model.Contact;
 

//Implementation of Data Access Layer for Contact
@Repository("ContactDao")
public class ContactDaoImpl extends AbstractDao<Integer, Contact> implements ContactDao {
 
	//Finds the contact by Id
    public Contact findById(int id) {
        return getByKey(id);
    }
 
    //Saves contact to database
    public void saveContact(Contact contact) {
        	save(contact);
    }
 
    //Lists the contacts with the given name
    @SuppressWarnings("unchecked")
    public List<Contact> findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Contact>) criteria.list();
    }
    
	//Finds if there is already a contact in the database with the given name and lastname
    public Contact findByNameAndLastName(String name, String lastName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.eq("lastName", lastName));
        return (Contact) criteria.uniqueResult();
    }
}