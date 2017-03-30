package org.struts.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class PaymentModel {
	private String holderName,cardNumber,cvv,expMonth,expYear,UUID_Or,UUID_Pay;
	private int shipTotal;

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getUUID_Or() {
		return UUID_Or;
	}

	public void setUUID_Or() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhmmss");
		Date date = new Date();
		String formattedDate = sdf.format(date);
		HttpSession se = ServletActionContext.getRequest().getSession();
		UUID_Or = "OD"+se.getAttribute("user").toString().substring(0,4).toUpperCase()+formattedDate;
		
	}

	public String getUUID_Pay() {
		return UUID_Pay;
	}

	public void setUUID_Pay() {
		//UUID_Pay = UUID.randomUUID().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhmmss");
		Date date = new Date();
		String formattedDate = sdf.format(date);
		HttpSession se = ServletActionContext.getRequest().getSession();
		UUID_Pay = "PD"+se.getAttribute("user").toString().substring(0,4).toUpperCase()+formattedDate;
	}

	public int getShipTotal() {
		return shipTotal;
	}

	public void setShipTotal(int shipTotal) {
		this.shipTotal = shipTotal;
	}
	
	

}
