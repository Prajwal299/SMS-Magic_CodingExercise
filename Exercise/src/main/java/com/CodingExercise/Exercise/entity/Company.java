package com.CodingExercise.Exercise.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;



//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Company {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @OneToMany(mappedBy = "company")
	    private List<ClientUser> clientUsers;

		public Company() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Company(String name, List<ClientUser> clientUsers) {
			super();
			this.name = name;
			this.clientUsers = clientUsers;
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public List<ClientUser> getClientUsers() {
			return clientUsers;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setClientUsers(List<ClientUser> clientUsers) {
			this.clientUsers = clientUsers;
		}

	    
}
