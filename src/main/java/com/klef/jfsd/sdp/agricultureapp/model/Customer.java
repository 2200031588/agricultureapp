package com.klef.jfsd.sdp.agricultureapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
	private String name;

	@NotBlank(message = "Address cannot be empty")
	@Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
	private String address;

	@NotBlank(message = "Contact number cannot be empty")
	@Pattern(regexp = "^\\d{10}$", message = "Contact must be a valid 10-digit number")
	private String contact;

	@NotBlank(message = "Password cannot be empty")
	@Size(min = 6, message = "Password must be at least 6 characters long")
	private String password;

	// Default constructor
	public Customer() {
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
