package com.xebia.training.refactor.strategy;

public abstract class CapitalStrategy {
	
	protected static final int MILLIS_PER_DAY = 86400000;
	private Loan loan;
	
	public CapitalStrategy(Loan loan) {
		this.loan=loan;
	}

	public double calculate(){
		return riskAmount(loan) * duration(loan) * RiskFactor.forRiskRating(loan.getRating());
	}

	protected abstract double duration(Loan loan);

	private double calcUnusedRiskAmount(Loan loan) {
        return (loan.getNotional() - loan.getOutstanding()) * loan.getUnusedPercentage();
    }
	
    private double riskAmount(Loan loan) {
        if (loan.getUnusedPercentage() != 1.00)
            return loan.getOutstanding() + calcUnusedRiskAmount(loan);
        else
            return loan.getOutstanding();
    }
}
