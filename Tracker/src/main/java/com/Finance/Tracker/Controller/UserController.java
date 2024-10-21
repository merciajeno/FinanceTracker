package com.Finance.Tracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Finance.Tracker.entities.Transactions;
import com.Finance.Tracker.entities.User;
import com.Finance.Tracker.repository.TransactionRepo;
import com.Finance.Tracker.repository.UserRepo;

@RestController
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	TransactionRepo transactionRepo;
	
	@PostMapping("/addUser")
	public void saveUser(@RequestBody User user)
	{
		userRepo.saveUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@RequestParam Long id)
	{
		userRepo.deleteUser(id);
	}
	
	@PutMapping("/addTransToUser/{id}")
	public void addTransToUser(@PathVariable Long id,@RequestBody Transactions transaction)
	{
		User user = userRepo.findById(id);
		transactionRepo.addTransactionToUser(transaction, user);
	}
}
