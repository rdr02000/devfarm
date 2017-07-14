package com.juve.payroll.tax.model;

public class TaxStatusPercentage {
	private float percent;
	private float taxableValue;
	private float taxDue;
	
	public float getTaxDue() {
		return taxDue;
	}
	public void setTaxDue(float taxDue) {
		this.taxDue = taxDue;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	public float getTaxableValue() {
		return taxableValue;
	}
	public void setTaxableValue(float taxableValue) {
		this.taxableValue = taxableValue;
	}
	
}