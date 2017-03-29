package com;

import java.util.*;

//interface for the contacts object
public class Contact {
	
	/*
	 * Interface block up top for ease of access
	 * 
	 * Interface:
	 *  void setID()
	 *  int getID()
	 *  void setFirstName()
	 *  String getFirstName()
	 *  void setLastName()
	 *  String getLastName()
	 *  void setAddress()
	 *  String getAddress()
	 *  void addEmail()
	 *  ArrayList<String> getAssociatedEmails()
	 *  void addPhoneNumber()
	 * 	void removePhoneNumber()
	 * 	ArrayList<String> getAssociatedPhoneNumbers()
	 *  void setBirthday()
	 *  Date getBirthday()
	 *  void setCompany()
	 *  String getCompany()
	 *  void setAssociation()
	 * 	String getAssociation()
	 * 	void setEmergency()
	 * 	boolean getEmergency()
	 *  void setDescription()
	 *  String getDescription()
	 *  void setModified()
	 *  boolean getModified()
	 *  void addTag()
	 *  void removeTag()
	 *  ArrayList<String> getAssociatedTags()
	 */
	private int id;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected ArrayList<String> associatedEmails;
	protected ArrayList<String> associatedPhoneNumbers;
	protected Date birthday;
	protected String company;
	protected String association;
	protected boolean isEmergency;
	protected String description;
	protected boolean isModified;
	protected ArrayList<String> associatedTags;
	
	// Constructor
	public Contact() {
		this.associatedEmails = new ArrayList<String>();
		this.associatedPhoneNumbers = new ArrayList<String>();
		this.associatedTags = new ArrayList<String>();
	}
	
	// sets id
	public void setID(int id) {
		this.id = id;
	}
	
	// gets id
	public int getID() {
		return this.id;
	}
	
	// sets first name of the contact
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// gets first name of contact
	public String getFirstName() {
		return this.firstName;
	}
	
	// sets the last name of the contact
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// gets the last name of the contact
	public String getLastName() {
		return this.lastName;
	}
	
	// sets the address of the contact
	public void setAddress(String address) {
		this.address = address;
	}
	
	// returns the address of the contact
	public String getAddress() {
		return this.address;
	}
	
	// adds an email to the email list
	public void addEmail(String email) {
		this.associatedEmails.add(email);
	}
	
	// removes an email from the list based on a linear search
	public void removeEmail(String email) {
		ListIterator<String> emailListIterator = this.associatedEmails.listIterator();
		while (emailListIterator.hasNext()) {
			String comparator = emailListIterator.next();
			if (comparator.equals(email)) {
				this.associatedEmails.remove(comparator);
				break;
			}
		}
	}
	
	// returns the email list
	public ArrayList<String> getAssociatedEmails() {
		return this.associatedEmails;
	}
	
	// adds a phone number
	public void addPhoneNumber(String number) {
		this.associatedPhoneNumbers.add(number);
	}
	
	// removes a phone number from the list based on
	// a linear search
	public void removePhoneNumber(String number) {
		ListIterator<String> phoneNumberListIterator = this.associatedPhoneNumbers.listIterator();
		while (phoneNumberListIterator.hasNext()) {
			String comparator = phoneNumberListIterator.next();
			if (comparator.equals(number)) {
				this.associatedEmails.remove(comparator);
				break;
			}
		}
	}
	
	// Returns the ArrayList of associated phone numbers
	public ArrayList<String> getAssociatedPhoneNumbers() {
		return this.associatedPhoneNumbers;
	}
	
	// sets the birthday of the object
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	// returns the birthday
	public Date getBirthday() {
		return this.birthday;
	}
	
	// sets what company this contact is with
	public void setCompany(String company) {
		this.company = company;
	}
	
	// gets what company this contact is with
	public String getCompany() {
		return this.company;
	}
	
	// sets what association the user is to this contact
	public void setAssociation(String association) {
		this.association = association;
	}
	
	// returns the specified association
	public String getAssociation() {
		return this.association;
	}
	
	// specifies whether this contact is an emergency contact
	public void setEmergency(boolean emergency) {
		this.isEmergency = emergency;
	}
	
	// specifies this as an emergency contact
	public boolean getEmergency() {
		return this.isEmergency;
	}
	
	// sets the description of this contact
	public void setDescription(String description) {
		this.description = description;
	}
	
	// gets the contact's description
	public String getDescription() {
		return this.description;
	}
	
	// sets whether this contact has been modified
	public void setModified(boolean modified) {
		this.isModified = modified;
	}
	
	// tells whether this contact has been modified
	public boolean getModified() {
		return this.isModified;
	}
	
	// adds a tag to this contact
	public void addTag(String tag) {
		this.associatedTags.add(tag);
	}
	
	// linear search to remove tag
	public void removeTag(String tag) {
		ListIterator<String> associatedTagIterator = this.associatedTags.listIterator();
		while (associatedTagIterator.hasNext()) {
			String comparator = associatedTagIterator.next();
			if (comparator.equals(tag)) {
				this.associatedTags.remove(comparator);
				break;
			}
		}
	}
	
	// returns an ArrayList of the associated tags
	public ArrayList<String> getAssociatedTags() {
		return this.associatedTags;
	}
}
