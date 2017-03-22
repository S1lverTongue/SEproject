package com;

//interface for the contacts object
public interface contacts {
	//returns the id number of the contact object
	int id();
	//returns the firstname of the contact
	String firstName();
	//returns the lastname of the contact
	String lastName();
	//returns the address of the contact
	String address();
	//returns the array of the email for the contact
	String[] email();
	//returns the array of the phone numbers for the contact
	String[] phoneNumber();
	//returns the birthday of the contact
	String birthday();
	//returns the company if the contact is associated with one
	String company();
	//returns the association you have with  the contact
	String association();
	//returns boolean for is an emergency contact or not
	boolean eContact();
	//returns any notes added to contacts
	String notes();
}
