package com.xebia.training.refactor.strategy;

public class BasicCapitalStrategy extends CapitalStrategy {

	public BasicCapitalStrategy(Loan loan) {
		super(loan);
	}

	@Override
	protected double duration(Loan loan) {
		long millisToExpiry = loan.getExpiry().getTime() - loan.getStart().getTime();
        long millisFromExpiryToMaturity = loan.getMaturity().getTime() - loan.getExpiry().getTime();
        double revolverDuration = (millisToExpiry / MILLIS_PER_DAY) / 365;
        double termDuration = (millisFromExpiryToMaturity / MILLIS_PER_DAY) / 365;
        return revolverDuration + termDuration;
	}

}
