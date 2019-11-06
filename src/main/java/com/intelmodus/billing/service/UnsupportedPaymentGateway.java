package com.intelmodus.billing.service;

class UnsupportedPaymentGateway extends RuntimeException {

	UnsupportedPaymentGateway(PaymentGateway paymentGateway) {
		super("Unsupported payment gateway: " + paymentGateway);
	}

}
