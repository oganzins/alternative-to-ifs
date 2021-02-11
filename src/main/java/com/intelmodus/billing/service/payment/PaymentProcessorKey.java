package com.intelmodus.billing.service.payment;

import com.intelmodus.billing.service.PaymentGateway;
import dagger.MapKey;

@MapKey
public @interface PaymentProcessorKey {

    PaymentGateway value();

}
