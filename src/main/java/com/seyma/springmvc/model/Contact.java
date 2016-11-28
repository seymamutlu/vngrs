package com.seyma.springmvc.model;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Implementation of domain model named "Contacts" which maps to the datatable named "contactnames"

@Entity
@Table(name="contactnames")
public class Contact implements Serializable {
 
	private static final long serialVersionUID = -7788619177798333712L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "lastName", nullable = false)
    private String lastName;

    
    //Getter and Setter methods
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Contact other = (Contact) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", lastName="
                + lastName + "]";
    }
     
}