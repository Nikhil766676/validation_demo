package com.statement.pdfgenerator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.statement.entity.Account;
import com.statement.entity.Transaction;

@Component
public class PdfGenerator {

	 public ByteArrayInputStream generateAccountStatementPdf(Account account) {
		  Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        try {
	            PdfWriter.getInstance(document, out);
	            document.open();

	            // Add account details
	            Font font = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
	            Paragraph para = new Paragraph("Account Statement", font);
	            para.setAlignment(Element.ALIGN_CENTER);
	            document.add(para);
	            document.add(new Paragraph(" "));
	            document.add(new Paragraph("Account Name			:" + account.getAccountHolderName()));
	            document.add(new Paragraph("Address 				:" + account.getAddress()));
	            document.add(new Paragraph("Date 					:" + account.getDate()));
	            document.add(new Paragraph("Account Number: " + account.getAccountNumber()));
	            document.add(new Paragraph("Account Description: " + account.getAccountDescription()));
	            document.add(new Paragraph("Branch: " + account.getBranch()));
	            document.add(new Paragraph("Drawing Power: " + account.getDrawingPower()));
	            document.add(new Paragraph("Mod Balance: " + account.getModBalance()));
	            document.add(new Paragraph("Cif No: " + account.getCifNo()));
	            document.add(new Paragraph("Ifs Code: " + account.getIfsCode()));
	            document.add(new Paragraph("Mirc Code: " + account.getMircCode()));
	            document.add(new Paragraph(" "));

	            // Add table of transactions
	            PdfPTable table = new PdfPTable(7);
	            table.setWidthPercentage(100);
	            table.setWidths(new int[]{2, 2, 4, 3, 2, 2, 2});

	            Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

	            PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("Txn Date", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Value Date", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Description", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Ref No./Cheque\r\n"
	            		+ "No.", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Debit", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Credit", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Balance", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            for (Transaction transaction : account.getTransactions()) {
	                PdfPCell cell;

	                cell = new PdfPCell(new Phrase(transaction.getTxnDate()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(transaction.getValuedate()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(transaction.getDescription()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(transaction.getRefNoChekNo()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(transaction.getDebit()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(transaction.getCredit()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(transaction.getBalance()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);


					/*
					 * cell = new PdfPCell(new Phrase(String.valueOf(transaction.getAmount())));
					 * cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					 * cell.setHorizontalAlignment(Element.ALIGN_RIGHT); cell.setPaddingRight(5);
					 * table.addCell(cell);
					 * 
					 * cell = new PdfPCell(new Phrase(transaction.getType()));
					 * cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					 * cell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(cell);
					 */
	            }

	            document.add(table);
	            document.close();
	        } catch (DocumentException ex) {
	            ex.printStackTrace();
	        }

	        return new ByteArrayInputStream(out.toByteArray());
		 
	 }
	 
}
