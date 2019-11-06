package com.intelmodus.billing.service;

import com.google.inject.AbstractModule;
import com.intelmodus.billing.service.payment.PaymentProcessorModule;

public class BillingServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bindClasses();
		installSubModules();
	}

	private void bindClasses() {
		bind(BillingService.class).to(DefaultBillingService.class);
		bind(PaymentProcessorRepository.class);
	}

	private void installSubModules() {
		install(new PaymentProcessorModule());
	}
}
