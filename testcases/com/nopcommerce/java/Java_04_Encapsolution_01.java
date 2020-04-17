package com.nopcommerce.java;

public class Java_04_Encapsolution_01 {

	public static void main(String[] args) {
		Java_04_Encapsolution_02 encap = new Java_04_Encapsolution_02();
		
		encap.showFirstAndLastName();
		System.out.println(encap.getFirstname());
		System.out.println(encap.getLastname());
		encap.setFirstname("Automation_1");
		encap.setLastname("Test_1");
		System.out.println(encap.getFirstname());
		System.out.println(encap.getLastname());
		
		System.out.println(encap.address);
		System.out.println(encap.city);
	}
}
