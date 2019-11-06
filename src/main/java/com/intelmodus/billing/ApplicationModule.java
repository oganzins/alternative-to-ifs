package com.intelmodus.billing;

import com.google.inject.AbstractModule;
import com.intelmodus.billing.service.BillingServiceModule;

class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new BillingServiceModule());
	}

}
