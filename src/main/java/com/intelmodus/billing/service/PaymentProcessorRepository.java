package com.intelmodus.billing.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.intelmodus.billing.service.payment.GooglePayProcessor;
import com.intelmodus.billing.service.payment.PayPalProcessor;
import com.intelmodus.billing.service.payment.ShopifyProcessor;

class PaymentProcessorRepository {

	private final Map<PaymentGateway, Supplier<PaymentProcessor>> paymentProcessors;

	PaymentProcessorRepository() {
		paymentProcessors = new HashMap<>();
		registerPaymentProcessors();
	}

	PaymentProcessor paymentProcessorBy(PaymentGateway paymentGateway) {
		return optionalPaymentProcessorOf(paymentGateway).orElseThrow(unsupported(paymentGateway));
	}

	private void registerPaymentProcessors() {
		paymentProcessors.put(PaymentGateway.PAYPAL, PayPalProcessor::new);
		paymentProcessors.put(PaymentGateway.GOOGLE_PAY, GooglePayProcessor::new);
		paymentProcessors.put(PaymentGateway.SHOPIFY, ShopifyProcessor::new);
	}

	private Optional<PaymentProcessor> optionalPaymentProcessorOf(PaymentGateway paymentGateway) {
		Supplier<PaymentProcessor> processorSupplier = paymentProcessors.get(paymentGateway);
		return Optional.ofNullable(processorSupplier).map(Supplier::get);
	}

	private Supplier<UnsupportedPaymentGateway> unsupported(PaymentGateway paymentGateway) {
		return () -> new UnsupportedPaymentGateway(paymentGateway);
	}

}
