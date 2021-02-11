package com.intelmodus.billing.service.payment;

import com.intelmodus.billing.service.PaymentProcessor;
import com.intelmodus.billing.service.Purchase;
import com.intelmodus.billing.service.Receipt;

class GooglePayProcessor implements PaymentProcessor {

    public Receipt process(Purchase purchase) {
        return new Receipt("Processed by Google Pay...");
    }
}
