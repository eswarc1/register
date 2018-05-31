package com.eswar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="users")
public class User {
	
    @Id
    @Column
	private String email;
    @Column
	private String firstName;
    @Column
	private String lastName;
    @Column
	private String phoneNumber;
    @Column
	private String password;
    
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
	
    
	
	
	
	
	
	
}
