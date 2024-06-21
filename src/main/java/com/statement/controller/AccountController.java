package com.statement.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.statement.entity.Account;
import com.statement.pdfgenerator.PdfGenerator;
import com.statement.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private PdfGenerator pdfGenerator;
	
	@GetMapping("/account/{accountNumber}/statement")
	public ResponseEntity<byte[]> getAccountStatement(@PathVariable String accountNumber) {
		Account account = accountService.getAccountStatement(accountNumber);
		ByteArrayInputStream bis = pdfGenerator.generateAccountStatementPdf(account);
		  byte[] pdfBytes;
	        pdfBytes = bis.readAllBytes();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=statement.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(pdfBytes);
	}
}
