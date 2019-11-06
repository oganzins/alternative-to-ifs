package com.intelmodus.billing.service.payment;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.intelmodus.billing.service.PaymentGateway;
import com.intelmodus.billing.service.PaymentProcessor;

public class PaymentProcessorModule extends AbstractModule {

	@Override
	protected void configure() {
		bindPaymentProcessor(PaymentGateway.GOOGLE_PAY, GooglePayProcessor.class);
		bindPaymentProcessor(PaymentGateway.SHOPIFY, ShopifyProcessor.class);
		bindPaymentProcessor(PaymentGateway.PAYPAL, PayPalProcessor.class);
	}

	private void bindPaymentProcessor(PaymentGateway paymentGateway,
			Class<? extends PaymentProcessor> paymentProcessorClass) {
		mapBinder().addBinding(paymentGateway).to(paymentProcessorClass);
	}

	private MapBinder<PaymentGateway, PaymentProcessor> mapBinder() {
		return MapBinder.newMapBinder(binder(), PaymentGateway.class, PaymentProcessor.class);
	}

}
