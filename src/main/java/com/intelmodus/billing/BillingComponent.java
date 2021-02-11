package com.intelmodus.billing;

import com.intelmodus.billing.service.BillingService;
import com.intelmodus.billing.service.BillingServiceModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {BillingServiceModule.class}
)
public interface BillingComponent {

    BillingService billingService();

}
