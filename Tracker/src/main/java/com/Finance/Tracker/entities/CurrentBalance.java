package com.Finance.Tracker.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class CurrentBalance {

	@Id
	@Column(name="user_id")
	Long user_id;
	BigDecimal balance_amount;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private User user;
    
	public User getUser() {
		return user;
	}
	
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CurrentBalance(Long id,BigDecimal balance_amount) {
		super();
		this.user_id = id;
		this.balance_amount = balance_amount;
	}
	public CurrentBalance() {
		super();
	}
	public Long getUser_id() {
		return user_id;
	}
	public BigDecimal getBalance_amount() {
		return balance_amount;
	}
	public void setBalance_amount(BigDecimal balance_amount) {
		this.balance_amount = balance_amount;
	}
	
	public String toString()
	{
		return "[current balance:+"+getBalance_amount()+"]";
	}
}
