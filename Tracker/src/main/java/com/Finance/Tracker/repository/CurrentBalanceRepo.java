package com.Finance.Tracker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Finance.Tracker.entities.CurrentBalance;
import com.Finance.Tracker.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CurrentBalanceRepo {

	@Autowired
	EntityManager em;
	
	
	public CurrentBalance findByID(Long id)
	{
		return em.find(CurrentBalance.class, id);
	}
	
	public void updateCurrentBalance(CurrentBalance currentBalance)
	{
		Long id = currentBalance.getUser_id();
		if(findByID(id)!=null)
		{
					em.merge(currentBalance);
		}
		else
			System.out.println("User not available");
	}
	
}
