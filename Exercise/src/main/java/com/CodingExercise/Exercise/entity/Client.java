package com.CodingExercise.Exercise.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;



import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Client {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Company company;

    @ManyToOne
    private User user;

    private String email;
    private String phone;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String name, Company company, User user, String email, String phone) {
		super();
		this.name = name;
		this.company = company;
		this.user = user;
		this.email = email;
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Company getCompany() {
		return company;
	}
	public User getUser() {
		return user;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    
    
    
}
