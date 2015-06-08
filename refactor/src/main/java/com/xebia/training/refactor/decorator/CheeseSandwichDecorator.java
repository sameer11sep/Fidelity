package com.xebia.training.refactor.decorator;

import java.math.BigDecimal;

public class CheeseSandwichDecorator implements AbstractSandwich {

	private AbstractSandwich sandwich;

	public CheeseSandwichDecorator(AbstractSandwich sandwich2) {
		this.sandwich=sandwich2;
	}

	public BigDecimal getPrice() {
		return this.sandwich.getPrice().add(BigDecimal.TEN);
	}

	public String getDescription() {
		return sandwich.getDescription()+" with Cheese";
	}

}
