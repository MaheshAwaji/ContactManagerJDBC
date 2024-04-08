package com.jspiders.contactmanager.entity;

public class Contact {
	private int id;
	private String FirstName;
	private String LastName;
	private long mobileNumber;
	private String email;
	private String Category;
	
	
	public Contact(int id, String firstName, String lastName, long mobileNumber2, String email, String category) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.mobileNumber = mobileNumber2;
		this.email = email;
		this.Category = category;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		this.Category = category;
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", category=" + Category + "]";
	}
	

}
