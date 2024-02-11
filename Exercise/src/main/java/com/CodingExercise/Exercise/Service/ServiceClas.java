package com.CodingExercise.Exercise.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingExercise.Exercise.Repo.ClientRepo;
import com.CodingExercise.Exercise.Repo.UserRepo;
import com.CodingExercise.Exercise.entity.Client;

@Service
public class ServiceClas {

	@Autowired
	UserRepo ur;
	
	@Autowired
	ClientRepo cr;
	
	
	public Client clientsave(Client client) {
	    return cr.save(client);
	}
}
