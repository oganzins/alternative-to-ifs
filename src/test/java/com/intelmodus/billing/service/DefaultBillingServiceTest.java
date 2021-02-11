package com.intelmodus.billing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultBillingServiceTest {

	private static final PaymentGateway PAYMENT_GATEWAY = PaymentGateway.GOOGLE_PAY;

	@Mock
	private PaymentProcessorRepository paymentProcessorRepository;

	@InjectMocks
	private DefaultBillingService billingService;

	@Mock
	private Purchase purchase;

	@Mock
	private PaymentProcessor paymentProcessor;

	@Test
	public void chargesForPurchase() {
		given(paymentProcessorRepository.paymentProcessorBy(PAYMENT_GATEWAY))
				.willReturn(paymentProcessor);

		billingService.charge(purchase, PAYMENT_GATEWAY);

		then(paymentProcessor).should().process(purchase);

	}

}