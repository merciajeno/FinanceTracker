package com.Finance.Tracker.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Finance.Tracker.entities.Category;
import com.Finance.Tracker.entities.Transactions;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CategoryRepo {

	@Autowired
	EntityManager em;
	
	public Category findById(Long id)
	{
		return em.find(Category.class, id);
	}
	
	public void saveCategory(Category category)
	{
		if(findById(category.getCategory_id())==null)
			em.persist(category);
		else
			em.merge(category);
	}
	
	public void addTransactionToCategory(Long trans_id,Long category_id)
	{
		Transactions transaction = em.find(Transactions.class, trans_id);
		Category category = em.find(Category.class,category_id);
	    if(transaction.getTransfer_type().equals("d"))
	    {
	    	transaction.setCategory(category);
	    	category.addTransaction(transaction);
	    	category.addAmountSpent(transaction.getAmount_transferred());
	    	em.merge(transaction);
	    	em.merge(category);
	    }
	}
	
	public List<Transactions> getTransactionForCategory(Long category_id)
	{
		Category category = findById(category_id);
		if(category==null)
		{
			System.out.println("Not available");
			return new ArrayList<>();
		}
		return category.getTransactions();
	}
}
