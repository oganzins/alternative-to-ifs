package com.intelmodus.billing.service;

public interface BillingService {

    Receipt charge(Purchase purchase, PaymentGateway paymentGateway);

}
