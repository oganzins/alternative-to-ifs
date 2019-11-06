package com.intelmodus.billing.service;

import com.intelmodus.billing.service.payment.GooglePayProcessor;
import com.intelmodus.billing.service.payment.PayPalProcessor;
import com.intelmodus.billing.service.payment.ShopifyProcessor;

public class BillingService {

	public Receipt charge(Purchase purchase, PaymentGateway paymentGateway) {
		PaymentProcessor paymentProcessor;
		if (PaymentGateway.PAYPAL == paymentGateway) {
			paymentProcessor = new PayPalProcessor();
		} else if (PaymentGateway.GOOGLE_PAY == paymentGateway) {
			paymentProcessor = new GooglePayProcessor();
		} else if (PaymentGateway.SHOPIFY == paymentGateway) {
			paymentProcessor = new ShopifyProcessor();
		} else {
			throw new UnsupportedPaymentGateway(paymentGateway);
		}
		return paymentProcessor.process(purchase);
	}

}
