package com.juve.payroll.tax;

import com.juve.payroll.tax.constant.TaxStatus;

public interface ITaxScheme {
	
	public float getWithHoldingTax(float netTaxableIncome, TaxStatus taxStatus, int year, String taxDistribution);
	public float getAnnualizedWithHoldingTax(float annualTaxableIncome, TaxStatus taxStatus, int year, String taxDistribution);
}
