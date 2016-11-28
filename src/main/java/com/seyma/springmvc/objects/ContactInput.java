package com.seyma.springmvc.objects;

//This model is created to be used as the import request file format 

public class ContactInput {
    public String name, lastName,phone;
    
    
    //Constructors
	public ContactInput(){};
	public ContactInput(String n, String l, String p){
		name=n;
		lastName=l;
		phone=p;
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

    
    public String get_phone() {
        return phone;
    }
    public void set_phone(String p)
    {
    	phone = p;
    }

};