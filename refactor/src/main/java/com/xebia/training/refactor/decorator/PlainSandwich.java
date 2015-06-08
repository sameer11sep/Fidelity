package com.xebia.training.refactor.decorator;

import java.math.BigDecimal;

public class PlainSandwich implements AbstractSandwich {

	BreadType breadType;

	public PlainSandwich(BreadType breadType) {
		this.breadType=breadType;
	}

	public BigDecimal getPrice() {
		return breadType.getPrice();
	}

	public String getDescription() {
		return "Sandwich with "+breadType;
	}

}
