package com.statement.entity;

import java.util.Date;
import java.util.List;

public class Account {

	
    private String accountHolderName;
    private String address;
    private String date;
    private String accountNumber;
    private String accountDescription;
    private String branch;
    private String drawingPower;
    //Interest Rate(% p.a.) 
    private String modBalance;
    private String cifNo;
    private String ifsCode;
    private String mircCode;
    
    
    private List<Transaction> transactions;
    
    public Account() {
		super();
	}
	
	public Account(String accountHolderName, String address, String date, String accountNumber, String accountDescription,
			String branch, String drawingPower, String modBalance, String cifNo, String ifsCode, String mircCode,
			List<Transaction> transactions) {
		super();
		this.accountHolderName = accountHolderName;
		this.address = address;
		this.date = date;
		this.accountNumber = accountNumber;
		this.accountDescription = accountDescription;
		this.branch = branch;
		this.drawingPower = drawingPower;
		this.modBalance = modBalance;
		this.cifNo = cifNo;
		this.ifsCode = ifsCode;
		this.mircCode = mircCode;
		this.transactions = transactions;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDrawingPower() {
		return drawingPower;
	}

	public void setDrawingPower(String drawingPower) {
		this.drawingPower = drawingPower;
	}

	public String getModBalance() {
		return modBalance;
	}

	public void setModBalance(String modBalance) {
		this.modBalance = modBalance;
	}

	public String getCifNo() {
		return cifNo;
	}

	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}

	public String getIfsCode() {
		return ifsCode;
	}

	public void setIfsCode(String ifsCode) {
		this.ifsCode = ifsCode;
	}

	public String getMircCode() {
		return mircCode;
	}

	public void setMircCode(String mircCode) {
		this.mircCode = mircCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
    
}
