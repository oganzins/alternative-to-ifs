package com.intelmodus.billing.service;

public class Purchase {

	private final String productName;

	public Purchase(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

}
