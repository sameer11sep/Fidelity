package com.xebia.training.refactor.strategy;

public class RevolverCapitalStrategy extends CapitalStrategy {

	public RevolverCapitalStrategy(Loan loan) {
		super(loan);
	}

	@Override
	protected double duration(Loan loan) {
		return ((loan.getExpiry().getTime() - loan.getStart().getTime()) / MILLIS_PER_DAY) / 365;
	}

}
