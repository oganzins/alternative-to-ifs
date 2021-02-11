package com.intelmodus.billing.service;

import com.intelmodus.billing.service.payment.PaymentProcessorModule;
import dagger.Binds;
import dagger.Module;

@Module(
        includes = {
                PaymentProcessorModule.class
        }
)
public interface BillingServiceModule {

    @Binds
    BillingService bindsBillingService(DefaultBillingService defaultBillingService);

}
