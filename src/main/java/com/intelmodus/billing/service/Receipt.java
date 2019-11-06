package com.intelmodus.billing.service;

public class Receipt {

	private final String paymentMessage;

	public Receipt(String paymentMessage) {
		this.paymentMessage = paymentMessage;
	}

	public String getPaymentMessage() {
		return paymentMessage;
	}

}
