package com.CodingExercise.Exercise.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;


//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	@OneToMany(mappedBy = "user")
	private List<ClientUser> clientUsers;

	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}

	public List<ClientUser> getClientUsers() {
		return clientUsers;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setClientUsers(List<ClientUser> clientUsers) {
		this.clientUsers = clientUsers;
	}

	public User(String username, List<ClientUser> clientUsers) {
		super();
		this.username = username;
		this.clientUsers = clientUsers;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
