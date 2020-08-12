package com.Hibe2.DemoBank;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account {
	@Id
	private int accNumber;
	private String bankName;
	private float balance;
	@ManyToOne
	@JoinColumn(name="CUST_ID", nullable=false)
	private Customer cust;
	
	
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public int getAccNumber() {
	return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", bankName=" + bankName + ", balance=" + balance + ", customer="
				+ cust + "]";
	}
	
	
	}

