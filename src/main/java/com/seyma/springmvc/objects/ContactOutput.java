package com.seyma.springmvc.objects;

import java.util.List;


//This model is created to be used as the get request's response format 


public class ContactOutput {
    public String name, lastName;
    public List<String> phones;
    
    //Constructors
	public ContactOutput(){};
	public ContactOutput(String n, String l, List<String> p){
		name=n;
		lastName=l;
		phones=p;
	};
    

	//Getter and Setter Methods
    public String get_name() {
        return name;
    }
    
    public void set_name(String n)
    {
    	name = n;
    }

    public String get_lastname() {
        return lastName;
    }
    
    public void set_lastname(String l)
    {
    	lastName = l;
    }

    
    public List<String> get_phones() {
        return phones;
    }
    public void set_phones(List<String> p)
    {
    	phones = p;
    }
    public void addPhone(String p)
    {
    	phones.add(p);
    }


};