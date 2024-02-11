package com.CodingExercise.Exercise.Controller;

import com.CodingExercise.Exercise.Repo.ClientRepo;
import com.CodingExercise.Exercise.Repo.CompanyRepo;
import com.CodingExercise.Exercise.Repo.UserRepo;
import com.CodingExercise.Exercise.Repo.clientUserRepo;
import com.CodingExercise.Exercise.Service.ServiceClas;
import com.CodingExercise.Exercise.entity.Client;
import com.CodingExercise.Exercise.entity.ClientUser;
import com.CodingExercise.Exercise.entity.Company;
import com.CodingExercise.Exercise.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientRepo clientRepository;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	ServiceClas sc;

	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	clientUserRepo cur;
	
	
	// 2.1) - List app Users
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	// 2.2) - Replace some User fields at once
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
		return userRepo.findById(id).map(user -> {
			newUser.setId(id);
			newUser.setUsername(newUser.getUsername());
			return new ResponseEntity<>(userRepo.save(newUser), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// 2.3) - Create some Client
	@PostMapping("/clients")

	public Client createClient(@RequestBody Client client) throws Exception {

		// return sc.clientsave(client);
		Client clnt = sc.clientsave(client);
		System.out.println("Hello");
		Company company = clnt.getCompany();
		Long companyId = company.getId();
		
		Optional<Company> compan = companyRepo.findById(companyId);
		if(compan.isPresent()) {
			//compan.get().setClientUsers(null);
			clnt.setCompany(compan.get());
			
		}else {
			throw new Exception("User not found");
		}
		
//		
		Long userId = clnt.getUser().getId();
		
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			clnt.setUser(user.get());
		}else {
			throw new Exception("User not found");
		}
		
//		
		
		
		
		return clnt;

	}
//	
	// 2.4) - Change any Client field
	 @PatchMapping("/clients/{id}")
	    public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
	        return clientRepository.findById(id).map(client -> {
	            if (updatedClient.getName() != null) {
	                client.setName(updatedClient.getName());
	            }
	            if (updatedClient.getEmail() != null) {
	                client.setEmail(updatedClient.getEmail());
	            }
	            if (updatedClient.getPhone() != null) {
	                client.setPhone(updatedClient.getPhone());
	            }

	            // Update the User associated with the Client
	            User updatedUser = updatedClient.getUser();
	            if (updatedUser != null) {
	                User existingUser = client.getUser();
	                if (existingUser != null) {
	                    if (updatedUser.getUsername() != null) {
	                        existingUser.setUsername(updatedUser.getUsername());
	                    }
	                    // Add similar checks for other User fields here...
	                } else {
	                    client.setUser(updatedUser);
	                }
	            }

	            // Update the Company associated with the Client
	            Company updatedCompany = updatedClient.getCompany();
	            if (updatedCompany != null) {
	                Company existingCompany = client.getCompany();
	                if (existingCompany != null) {
	                    if (updatedCompany.getName() != null) {
	                        existingCompany.setName(updatedCompany.getName());
	                    }
	                   
	                } else {
	                    client.setCompany(updatedCompany);
	                }
	            }

	            return clientRepository.save(client);
	        }).orElse(null);
	    }

	 
	 
	

}
