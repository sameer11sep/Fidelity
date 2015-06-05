package com.xebia.training.refactor.decorator;

import java.math.BigDecimal;

public enum BreadType {
    WHITE {
        @Override
        public BigDecimal getPrice() {
            return BigDecimal.TEN;
        }
    },BROWN {
        @Override
        public BigDecimal getPrice() {
            return BigDecimal.valueOf(15.0);
        }
    },OREGANO {
        @Override
        public BigDecimal getPrice() {
            return BigDecimal.valueOf(20.0);
        }
    };

    public abstract BigDecimal getPrice() ;
}
