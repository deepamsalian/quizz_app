package mykiddrawing.quiz.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mykiddrawing.quiz.exception.ResourceNotFoundException;
import mykiddrawing.quiz.model.Coins;
import mykiddrawing.quiz.model.User;
import mykiddrawing.quiz.repository.CoinsRepository;
import mykiddrawing.quiz.repository.UserRepository;



@RestController
@RequestMapping("/api")
public class CoinsController {
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	CoinsRepository coinsrepository;
	
	
		// Update a coin
		@PutMapping("/users/{user_id}/coins")
		public Coins updateCoin(@PathVariable(value = "user_id") Long user_id,
		                                        @Valid @RequestBody Coins coins) throws ResourceNotFoundException {

		   User c = userrepository.findById(user_id)
		            .orElseThrow(() -> new ResourceNotFoundException("User"+ user_id+"not found"));

		   Coins cn=new Coins();	   
		    cn.setNo_of_coins(coins.getNo_of_coins());
		  //  cn.setRank_id(coins.getRank_id());
		    cn.setUser(c);
		    Coins updatedCoin = coinsrepository.save(cn);
		    return updatedCoin;
		}
		
		// Get a Single user's coin details

	    @GetMapping("/users/{user_id}/coin")
	    public Coins getUserCoinById(@PathVariable(value = "user_id") Long user_id) throws ResourceNotFoundException {
	        return coinsrepository.findById(user_id)
	                .orElseThrow(() -> new ResourceNotFoundException("user"+ user_id+"	not found"));
	    }
	    
	    
	    @GetMapping("/users/coins")
	    public List<Coins> getUserCoins()
	    {
	    	return coinsrepository.findAll();
	    }

	    
	    
	    

}
