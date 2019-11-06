package com.intelmodus.billing.service;

public interface PaymentProcessor {

	Receipt process(Purchase purchase);

}
