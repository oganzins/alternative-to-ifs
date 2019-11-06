package com.intelmodus.billing;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.intelmodus.billing.service.BillingService;
import com.intelmodus.billing.service.PaymentGateway;
import com.intelmodus.billing.service.Purchase;
import com.intelmodus.billing.service.Receipt;

public class BillingApplication {

	public static void main(String[] args) {
		BillingService billingService = injector().getInstance(BillingService.class);
		Receipt receipt = billingService.charge(purchaseOf(args), paymentGatewayOf(args));

		System.out.println(receipt.getPaymentMessage());
	}

	private static Injector injector() {
		return Guice.createInjector(new ApplicationModule());
	}

	private static Purchase purchaseOf(String[] args) {
		return new Purchase(args[0]);
	}

	private static PaymentGateway paymentGatewayOf(String[] args) {
		return PaymentGateway.valueOf(args[1]);
	}

}
