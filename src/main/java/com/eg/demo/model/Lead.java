package com.eg.demo.model;

import java.io.Serializable;

public class Lead implements Serializable
{
	//private static final long serialVersionUID = 1L;

	//private Integer id;

	private String firstName;
	private String lastName;
	private String email;
	private Integer phoneno;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Integer phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "Lead [firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ",Phoneno:"+phoneno+"]";
	}
}