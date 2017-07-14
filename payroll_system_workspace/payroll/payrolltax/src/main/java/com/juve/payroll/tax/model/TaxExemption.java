package com.juve.payroll.tax.model;


import java.util.Map;

import com.juve.payroll.tax.constant.TaxStatus;

public class TaxExemption {
	private int year;
	private Map<TaxStatus, Float> exemptionList;
	

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setExemptionList(Map<TaxStatus, Float> exemptionList) {
		this.exemptionList = exemptionList;
	}
	
	public Map<TaxStatus, Float> getExemptionList() {
		return exemptionList;
	}
}
