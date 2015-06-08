package com.xebia.training.refactor.strategy;

import java.util.Date;

public class Loan {
    private double notional;
    private double outstanding;
    private int rating;
    private Date start;
    private Date expiry;
    public double getNotional() {
		return notional;
	}

	public double getOutstanding() {
		return outstanding;
	}

	public Date getStart() {
		return start;
	}

	public Date getExpiry() {
		return expiry;
	}

	public Date getMaturity() {
		return maturity;
	}

	public double getUnusedPercentage() {
		return unusedPercentage;
	}

	private Date maturity;
    private double unusedPercentage;

    public Loan(double notional, int rating, Date start, Date expiry, Date maturity) {
        this.notional = notional;
        this.rating = rating;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
        setUnusedPercentage();
    }

    public double calculateCapital() {
    	CapitalStrategy strategy=new CapitalStrategyFactory().create(this);
    	return strategy.calculate();
    }

    

    public void setOutstanding(double newOutstanding) {
        outstanding = newOutstanding;
    }

    private void setUnusedPercentage() {
        if (expiry != null && maturity != null) {
            if (rating > 4)
                unusedPercentage = 0.95;
            else
                unusedPercentage = 0.50;
        } else if (maturity != null) {
            unusedPercentage = 1.00;
        } else if (expiry != null) {
            if (rating > 4)
                unusedPercentage = 0.75;
            else
                unusedPercentage = 0.25;
        }
    }

	public int getRating() {
		return this.rating;
	}
}
