package com.intelmodus.billing.service.payment;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.intelmodus.billing.service.Purchase;
import com.intelmodus.billing.service.Receipt;

@RunWith(MockitoJUnitRunner.class)
public class PayPalProcessorTest {

    @Mock
    private Purchase purchase;

    @Test
    public void processesPurchase() {
        PayPalProcessor payPal = new PayPalProcessor();
        Receipt receipt = payPal.process(purchase);

        assertThat(receipt.getPaymentMessage()).isEqualTo("Processed by PayPal...");
    }

}