package com.mkd.quizz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mkd.quizz.exception.ResourceNotFoundException;

import com.mkd.quizz.model.User;

import com.mkd.quizz.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userrepository;
	
	//create user
	 @PostMapping("/users")
	    public User createUser(@Valid @RequestBody User user) {
	        return userrepository.save(user);
	    }

		
	 // Get a Single user

	    @GetMapping("/users/{user_id}")
	    public User getUserById(@PathVariable(value = "user_id") Long user_id) {
	        return userrepository.findById(user_id)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "user_id", user_id));
	    }
	    
	 // delete user
	    
	    @DeleteMapping("/users/{user_id}")
	    public ResponseEntity<?> deleteUser(@PathVariable(value = "user_id") Long user_id) {
	        User u = userrepository.findById(user_id)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "user_id", user_id));

	        userrepository.delete(u);

	        return ResponseEntity.ok().build();
	    }
	 
	

}
