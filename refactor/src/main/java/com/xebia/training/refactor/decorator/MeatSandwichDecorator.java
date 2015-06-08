package com.xebia.training.refactor.decorator;

import java.math.BigDecimal;

public class MeatSandwichDecorator implements AbstractSandwich {

	private AbstractSandwich sandwich;
	
	public MeatSandwichDecorator(AbstractSandwich sandwich) {
		this.sandwich = sandwich;
	}

	public BigDecimal getPrice() {
		return sandwich.getPrice().add(BigDecimal.valueOf(25.0));
	}

	public String getDescription() {
		return sandwich.getDescription()+" and Meat";
	}

}
