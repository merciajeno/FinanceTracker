package com.Finance.Tracker.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Finance.Tracker.entities.CurrentBalance;
import com.Finance.Tracker.entities.Transactions;
import com.Finance.Tracker.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class TransactionRepo {

	@Autowired
	EntityManager em;
	
	@Autowired
	CurrentBalanceRepo currentBalanceRepo;
	public void addTransactionToUser(Transactions transaction,User user)
	{
	  if(em.find(User.class, user.getId())==null)
	  {
		  System.out.println("User does not exist");
		  return;
	  }
	  Long id = user.getId();
	  BigDecimal balance_amount = em.find(CurrentBalance.class, id).getBalance_amount();
	  String transfer_type = transaction.getTransfer_type();
	  if(transfer_type.equals("c"))
		 balance_amount =  balance_amount.add(transaction.getAmount_transferred());
	  else
	  {
		  if(balance_amount.compareTo(transaction.getAmount_transferred())==-1)
		  {
			  System.out.println("Amount is insufficient");
			  return;
		  }
		  balance_amount = balance_amount.subtract(transaction.getAmount_transferred());
	  }
	  System.out.println(balance_amount);
	  CurrentBalance currentBalance = em.find(CurrentBalance.class,id);
	  currentBalance.setBalance_amount(balance_amount);
	  currentBalanceRepo.updateCurrentBalance(currentBalance);
	  user.addTransaction(transaction);
	  transaction.setUser(user);
	  em.persist(transaction);
			  
	}
	
}
