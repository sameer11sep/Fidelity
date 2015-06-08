package com.xebia.training.refactor.decorator;

import java.math.BigDecimal;

public class SauceDecorator implements AbstractSandwich {

	private AbstractSandwich sandwich;

	public SauceDecorator(AbstractSandwich sandwich) {
		this.sandwich=sandwich;
	}

	public BigDecimal getPrice() {
		return sandwich.getPrice().add(BigDecimal.TEN);
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
