package com.xebia.training.refactor.strategy;

public class CapitalStrategyFactory {

	public CapitalStrategy create(Loan loan) {
		if(loan.getMaturity() == null){
			return new RevolverCapitalStrategy(loan);
		}else if(loan.getExpiry() == null){
			return new TermLoanCapitalStrategy(loan);
		}
		return new BasicCapitalStrategy(loan);
	}

}
