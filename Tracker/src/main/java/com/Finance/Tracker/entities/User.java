package com.Finance.Tracker.entities;

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
public class User {

	@Id
	private Long id;
	private String name;
	private String email;
	private String password;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CurrentBalance currentBalance;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="user",cascade = CascadeType.ALL)
	private List<Transactions> transactions = new ArrayList<>();
	
	
	public List<Transactions> getTransactions() {
		return transactions;
	}
	
	public void addTransaction(Transactions transaction)
	{
		transactions.add(transaction);
	}
	
	public void removeTransaction(Transactions transaction)
	{
		transactions.remove(transaction);
	}
	public User()
	{
		super();
	}
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public User(Long id,String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString()
	{
		return "name: "+getName()+", email: "+getEmail();
	}

	public CurrentBalance getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(CurrentBalance currentBalance) {
		this.currentBalance = currentBalance;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	

	
	
}
