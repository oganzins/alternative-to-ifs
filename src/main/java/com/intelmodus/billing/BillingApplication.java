package com.intelmodus.billing;

import com.intelmodus.billing.service.*;

public class BillingApplication {

    public static void main(String[] args) {
        BillingComponent component = DaggerBillingComponent.builder().build();
        BillingService billingService = component.billingService();
        Receipt receipt = billingService.charge(purchaseOf(args), paymentGatewayOf(args));

        System.out.println(receipt.getPaymentMessage());
    }

    private static Purchase purchaseOf(String[] args) {
        return new Purchase(args[0]);
    }

    private static PaymentGateway paymentGatewayOf(String[] args) {
        return PaymentGateway.valueOf(args[1]);
    }

}
