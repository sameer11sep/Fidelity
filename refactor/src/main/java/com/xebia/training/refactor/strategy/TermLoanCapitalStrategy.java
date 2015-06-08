package com.xebia.training.refactor.strategy;

public class TermLoanCapitalStrategy extends CapitalStrategy{

	public TermLoanCapitalStrategy(Loan loan) {
		super(loan);
	}

	@Override
	protected double duration(Loan loan) {
		return ((loan.getMaturity().getTime() - loan.getStart().getTime()) / MILLIS_PER_DAY) / 365;
	}

	
}
