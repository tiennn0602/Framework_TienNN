package com.nopcommerce.java;

public class Java_04_Encapsolution_02 {
	public String address = "District 12", city = "HCM";
	String phone = "123", email = "tien.nguyen@gmail.com";
	protected String password = "pwd@123#";
	private String firstname = "Automation", lastname = "Test";
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void showFirstAndLastName() {
		System.out.println("FirstName = " + firstname);
		System.out.println("LastName = " + lastname);
	}
}
