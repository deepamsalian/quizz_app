package com.mkd.quizz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkd.quizz.exception.ResourceNotFoundException;
import com.mkd.quizz.model.Coins;
import com.mkd.quizz.model.User;
import com.mkd.quizz.repository.CoinsRepository;
import com.mkd.quizz.repository.UserRepository;


@RestController
@RequestMapping("/api")
public class CoinsController {
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	CoinsRepository coinsrepository;
	
	
		// Update a coin
		@PutMapping("/coins/{user_id}")
		public Coins updateCoin(@PathVariable(value = "user_id") Long user_id,
		                                        @Valid @RequestBody Coins coins) {

		   User c = userrepository.findById(user_id)
		            .orElseThrow(() -> new ResourceNotFoundException("User", "user_id", user_id));

		   Coins cn=new Coins();	   
		    cn.setNo_of_coins(coins.getNo_of_coins());
		    cn.setRank_id(coins.getRank_id());
		    cn.setUser(c);
		    Coins updatedCoin = coinsrepository.save(cn);
		    return updatedCoin;
		}
		
		// Get a Single user's coin details

	    @GetMapping("/coins/{user_id}")
	    public Coins getUserCoinById(@PathVariable(value = "user_id") Long user_id) {
	        return coinsrepository.findById(user_id)
	                .orElseThrow(() -> new ResourceNotFoundException("Coins", "user_id", user_id));
	    }

}
