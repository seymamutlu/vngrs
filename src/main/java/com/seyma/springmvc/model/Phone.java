package com.seyma.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Implementation of domain model named "Phone" which maps to the datatable named "phonenumbers"

@Entity
@Table(name="phonenumbers")
public class Phone implements Serializable {

	private static final long serialVersionUID = 2869565853377398680L;

	@Id
	@Column(name="contactId", nullable = false)
	private int contactId;
	
	@Id
	@Column(name="phoneNumber", nullable = false)
	private String phoneNumber;

   //Getter Setter methods
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + contactId;
	        return result;
	    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Contact))
            return false;
        Phone other = (Phone) obj;
        if (contactId != other.contactId && phoneNumber!=other.phoneNumber)
            return false;
        return true;
    }
}