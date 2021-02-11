package com.intelmodus.billing.service.payment;

import com.intelmodus.billing.service.PaymentGateway;
import com.intelmodus.billing.service.PaymentProcessor;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class PaymentProcessorModule {

    @Provides
    @IntoMap
    @PaymentProcessorKey(PaymentGateway.GOOGLE_PAY)
    static PaymentProcessor providesGooglePay() {
        return new GooglePayProcessor();
    }

    @Provides
    @IntoMap
    @PaymentProcessorKey(PaymentGateway.PAYPAL)
    static PaymentProcessor providesPayPal() {
        return new PayPalProcessor();
    }

    @Provides
    @IntoMap
    @PaymentProcessorKey(PaymentGateway.SHOPIFY)
    static PaymentProcessor providesShopify() {
        return new ShopifyProcessor();
    }

}
