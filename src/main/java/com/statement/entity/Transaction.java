package com.statement.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String txnDate;
	private String valuedate;
    private String description;
    private String refNoChekNo;
    private String debit;
    private String credit;
    private String balance;
	public Transaction() {
		super();
	}
	public Transaction(String txnDate, String valuedate, String description, String refNoChekNo, String debit,
			String credit, String balance) {
		super();
		this.txnDate = txnDate;
		this.valuedate = valuedate;
		this.description = description;
		this.refNoChekNo = refNoChekNo;
		this.debit = debit;
		this.credit = credit;
		this.balance = balance;
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public String getValuedate() {
		return valuedate;
	}
	public void setValuedate(String valuedate) {
		this.valuedate = valuedate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRefNoChekNo() {
		return refNoChekNo;
	}
	public void setRefNoChekNo(String refNoChekNo) {
		this.refNoChekNo = refNoChekNo;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

    
}
