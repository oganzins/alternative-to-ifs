package com.intelmodus.billing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentProcessorRepositoryTest {

	private static final PaymentGateway PAYMENT_GATEWAY = PaymentGateway.GOOGLE_PAY;

	@Mock
	private Map<PaymentGateway, PaymentProcessor> paymentProcessors;

	@InjectMocks
	private PaymentProcessorRepository repository;

	@Mock
	private PaymentProcessor paymentProcessor;

	@Test
	public void retrievesPaymentProcessor() {
		given(paymentProcessors.get(PAYMENT_GATEWAY)).willReturn(paymentProcessor);
		assertThat(repository.paymentProcessorBy(PAYMENT_GATEWAY)).isSameAs(paymentProcessor);
	}

	@Test
	public void failsWhenGatewayIsUnsupported() {
		assertThatThrownBy(() -> repository.paymentProcessorBy(PAYMENT_GATEWAY))
				.isInstanceOf(UnsupportedPaymentGateway.class)
				.hasMessage("Unsupported payment gateway: GOOGLE_PAY");
	}

}