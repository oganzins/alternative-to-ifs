package com.intelmodus.billing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Before;
import org.junit.Test;

public class BillingServiceTest {

	private BillingService billingService;

	private Purchase purchase;

	@Before
	public void setUp() {
		billingService = new BillingService();
		purchase = new Purchase("Sandwich");
	}

	@Test
	public void usesPayPal() {
		Receipt receipt = billingService.charge(purchase, PaymentGateway.PAYPAL);
		assertThat(receipt.getPaymentMessage()).isEqualTo("Processed by PayPal...");
	}

	@Test
	public void usesGooglePay() {
		Receipt receipt = billingService.charge(purchase, PaymentGateway.GOOGLE_PAY);
		assertThat(receipt.getPaymentMessage()).isEqualTo("Processed by Google Pay...");
	}

	@Test
	public void usesShopify() {
		Receipt receipt = billingService.charge(purchase, PaymentGateway.SHOPIFY);
		assertThat(receipt.getPaymentMessage()).isEqualTo("Processed by Shopify...");
	}

	@Test
	public void failsWhenGatewayIsUnsupported() {
		assertThatThrownBy(() -> billingService.charge(purchase, PaymentGateway.SKRILL))
				.isInstanceOf(UnsupportedPaymentGateway.class)
				.hasMessage("Unsupported payment gateway: SKRILL");
	}

}