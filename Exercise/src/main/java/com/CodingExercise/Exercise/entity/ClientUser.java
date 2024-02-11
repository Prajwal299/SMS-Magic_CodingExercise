package com.CodingExercise.Exercise.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;

@Entity
public class ClientUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Client client;

	@ManyToOne
	private User user;

	@ManyToOne
	private Company company;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;

	private boolean active;

	public ClientUser() {
		super();
	}

	public ClientUser(Client client, User user, LocalDateTime createdAt, LocalDateTime updatedAt,
			LocalDateTime deletedAt, boolean active) {
		super();
		this.client = client;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public User getUser() {
		return user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public boolean isActive() {
		return active;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
