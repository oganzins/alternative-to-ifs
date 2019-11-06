package com.intelmodus.billing.service;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class PaymentProcessorRepository {

	private final Map<PaymentGateway, PaymentProcessor> paymentProcessors;

	@Inject
	PaymentProcessorRepository(Map<PaymentGateway, PaymentProcessor> paymentProcessors) {
		this.paymentProcessors = paymentProcessors;
	}

	PaymentProcessor paymentProcessorBy(PaymentGateway paymentGateway) {
		PaymentProcessor paymentProcessor = paymentProcessors.get(paymentGateway);
		return Optional.ofNullable(paymentProcessor).orElseThrow(unsupported(paymentGateway));
	}

	private Supplier<UnsupportedPaymentGateway> unsupported(PaymentGateway paymentGateway) {
		return () -> new UnsupportedPaymentGateway(paymentGateway);
	}

}
