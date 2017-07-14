package com.juve.payroll.tax.model;

import java.util.List;

import com.juve.payroll.tax.constant.TaxStatus;

public class Tax {
	private int taxYear;
	private String taxDistribution;
	private TaxStatus taxStatus;
	
	public TaxStatus getTaxStatus() {
		return taxStatus;
	}
	public void setTaxStatus(TaxStatus taxStatus) {
		this.taxStatus = taxStatus;
	}
	private List<TaxStatusPercentage> taxStatusPercentage;
	
	public int getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}
	public String getTaxDistribution() {
		return taxDistribution;
	}
	public void setTaxDistribution(String taxDistribution) {
		this.taxDistribution = taxDistribution;
	}
	public List<TaxStatusPercentage> getTaxStatusPercentage() {
		return taxStatusPercentage;
	}
	public void setTaxStatusPercentage(List<TaxStatusPercentage> taxStatusPercentage) {
		this.taxStatusPercentage = taxStatusPercentage;
	}
}