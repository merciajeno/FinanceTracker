package com.Finance.Tracker.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Transactions {

	@Id
	Long trans_id;
	
	BigDecimal amount_transferred;
	String transfer_type;
	
	LocalDate txn_date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	
	public Transactions() {
		super();
	}

	public Transactions(Long trans_id,BigDecimal amount_transferred, String transfer_type, LocalDate txn_date) {
		super();
		this.trans_id = trans_id;
		this.amount_transferred = amount_transferred;
		this.transfer_type = transfer_type;
		this.txn_date = txn_date;
	}

	public Long getTrans_id() {
		return trans_id;
	}

	

	public BigDecimal getAmount_transferred() {
		return amount_transferred;
	}

	public String getTransfer_type() {
		return transfer_type;
	}

	public LocalDate getTxn_date() {
		return txn_date;
	}

	public void setAmount_transferred(BigDecimal amount_transferred) {
		this.amount_transferred = amount_transferred;
	}

	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}

	public void setTxn_date(LocalDate txn_date) {
		this.txn_date = txn_date;
	}
	public void setUser(User user)
	{
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String toString()
	{
		return "transaction :"+getAmount_transferred()+" transfer type:"+getTransfer_type();
	}
	
}
