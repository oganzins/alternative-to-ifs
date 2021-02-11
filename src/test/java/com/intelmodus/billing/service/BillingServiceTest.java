package com.intelmodus.billing.service;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class BillingServiceTest {

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