package com.statement.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statement.entity.Account;
import com.statement.entity.Transaction;
import com.statement.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private TransactionRepository transRepo;

	@Override
	public Account getAccountStatement(String accountNumber) {
		List<Transaction> transactions=transRepo.findAll();
		Account account = new Account();
		account.setAccountHolderName("Nikhil Nalabothula");
		account.setAddress("H NO 33-115/1\r\n"
				+ " PANGAL ROAD \r\n"
				+ " WANAPARTHY-509103 \r\n"
				+ " MAHBUBNAGAR");
		account.setDate("13 Mar 2023");
		account.setAccountNumber(accountNumber);
		account.setAccountDescription("REGULAR SB NCHQ-INDIVIDUALS");
		account.setBranch("WANAPARTHY");
		account.setDrawingPower("0.00");
		account.setModBalance("0.00");
		account.setCifNo("72223341567");
		account.setIfsCode("SBIN0020187");
		account.setMircCode("509002106");
        account.setTransactions(transactions);
        return account;
	}

}
