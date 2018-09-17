package com.mortgagekaki.loanapi.models;

import java.math.BigDecimal;

public class Rate {

    private final BaseRate baseRate;

    private final BigDecimal absoluteRate;

    public Rate(BaseRate baseRate, BigDecimal absoluteRate) {
        this.baseRate = baseRate;
        this.absoluteRate = absoluteRate;
    }


    public BaseRate getBaseRate() {
        return baseRate;
    }

    public BigDecimal getAbsoluteRate() {
        return absoluteRate;
    }
}
