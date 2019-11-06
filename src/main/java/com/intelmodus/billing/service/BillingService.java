package com.intelmodus.billing.service;

public class BillingService {

	private final PaymentProcessorRepository processorRepository;

	public BillingService() {
		processorRepository = new PaymentProcessorRepository();
	}

	public Receipt charge(Purchase purchase, PaymentGateway paymentGateway) {
		PaymentProcessor paymentProcessor = processorRepository.paymentProcessorBy(paymentGateway);
		return paymentProcessor.process(purchase);
	}

}
