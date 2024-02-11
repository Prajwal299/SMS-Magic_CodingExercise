package com.CodingExercise.Exercise.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.CodingExercise.Exercise.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

	 @GetMapping
	    public List<User> listUsers(@RequestParam(value = "username", required = false) String username) {
			return null;
	        // implement the filtering logic here
	    }

	    @PutMapping("/{id}")
	    public User updateUser(@PathVariable Long id, @RequestBody User user) {
			return user;
	        // implement the update logic here
	    }
	    
	    
	    
	    
	
}
