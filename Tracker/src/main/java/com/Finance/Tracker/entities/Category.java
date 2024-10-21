package com.Finance.Tracker.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Category {

	@Id
	private Long category_id;
	private String category_name;
	private BigDecimal amount_spent;
	
	@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
	private List<Transactions> transactions = new ArrayList<>();
	
	public Category(Long category_id, String category_name, BigDecimal amount_spent) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.amount_spent = amount_spent;
	}
	public Category(String category_name, BigDecimal amount_spent) {
		super();
		this.category_name = category_name;
		this.amount_spent = amount_spent;
	}
	public Category(Long category_id,String category_name)
	{
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}
	public Category() {
		super();
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public BigDecimal getAmount_spent() {
		return amount_spent;
	}
	public void setAmount_spent(BigDecimal amount_spent) {
		this.amount_spent = amount_spent;
	}
	public Long getCategory_id() {
		return category_id;
	}
	
	public void addTransaction(Transactions transacation)
	{
		this.transactions.add(transacation);
	}
	public List<Transactions> getTransactions() {
		return transactions;
	}
	
	public void removeTransaction(Transactions transaction)
	{
		this.transactions.remove(transaction);
	}
	
	public void addAmountSpent(BigDecimal amount)
	{
		this.amount_spent = this.amount_spent.add(amount);
	}
}
