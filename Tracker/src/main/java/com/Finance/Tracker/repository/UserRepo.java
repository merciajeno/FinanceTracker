package com.Finance.Tracker.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Finance.Tracker.entities.CurrentBalance;
import com.Finance.Tracker.entities.Transactions;
import com.Finance.Tracker.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepo {

	@Autowired
	EntityManager em;
	
	@Autowired
	CurrentBalanceRepo currentBalanceRepo;
	
	public User findById(Long id)
	{
		return em.find(User.class, id);
	}
	
	public void saveUser(User user)
	{
	    if(findById(user.getId())==null)
	    {
	    	CurrentBalance currentBalance = new CurrentBalance(user.getId(),new BigDecimal(0.0));
			user.setCurrentBalance(currentBalance);
			currentBalance.setUser(user);
			em.persist(user);
	    	
	    }
	    else
	    	em.merge(user);
	}
	
	public CurrentBalance getCurrentBalanceOfUser(User user)
	{
		if(findById(user.getId())!=null)
		{
			Long id = user.getId();
			return currentBalanceRepo.findByID(id);
		}
		return null;
	}
	
	public void deleteUser(Long id)
	{
		User user = findById(id);
		if(user==null)
		{
			System.out.println("User not available");
			return;
		}
		em.remove(user);
	}
	
	
	}
