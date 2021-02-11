package com.intelmodus.billing.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
class DefaultBillingService implements BillingService {

    private final PaymentProcessorRepository paymentProcessorRepository;

    @Inject
    DefaultBillingService(PaymentProcessorRepository paymentProcessorRepository) {
        this.paymentProcessorRepository = paymentProcessorRepository;
    }

    @Override
    public Receipt charge(Purchase purchase, PaymentGateway paymentGateway) {
        PaymentProcessor paymentProcessor = paymentProcessorRepository.paymentProcessorBy(paymentGateway);
        return paymentProcessor.process(purchase);
    }

}
