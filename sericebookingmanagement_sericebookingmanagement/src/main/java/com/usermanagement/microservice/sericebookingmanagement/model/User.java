package com.usermanagement.microservice.sericebookingmanagement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;
	
	@Column(name = "emailid")
	private String emailId;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "registrationdate")
	private String registrationDate;
	
	public User()
	{
		
	}

	public User(long id, String name, String password, String emailId, String mobile, String registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.mobile = mobile;
		this.registrationDate = registrationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
}
