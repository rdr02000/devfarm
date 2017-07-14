package com.juve.payroll.tax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.juve.payroll.tax.configuration.LoadTaxProperties;
import com.juve.payroll.tax.constant.TaxStatus;
import com.juve.payroll.tax.model.Tax;
import com.juve.payroll.tax.model.TaxExemption;
import com.juve.payroll.tax.model.TaxStatusPercentage;

public class TaxScheme implements ITaxScheme {
	private ObjectMapper mapper;
	
	private static final String TAXABLE_TABLE_LOC = "C:\\development\\payroll_system\\payroll_system_workspace\\taxtable\\"; //to be put in a property file 
	private static final String TAXABLE_EXEMPTION = "C:\\development\\payroll_system\\payroll_system_workspace\\taxtable\\exemption.json"; //to be put in a property file 
	
	public TaxScheme() {
		this.mapper = new ObjectMapper();
	}
	
	public float getWithHoldingTax(float netTaxableIncome, TaxStatus taxStatus, int year, String taxDistribution) {
		File file = new File(TAXABLE_TABLE_LOC + "\\tax" + year + taxDistribution + taxStatus + ".json");
		LoadTaxProperties<Tax> taxProp = new LoadTaxProperties<Tax>(Tax.class);
		Tax tax = taxProp.loadTaxProperties(this.mapper, file);
		
		TaxStatusPercentage prcntToUse = null;
		for (TaxStatusPercentage prcnt : tax.getTaxStatusPercentage()) {
			if (netTaxableIncome > prcnt.getTaxableValue()) {
				prcntToUse = prcnt;
			}
		}
		
		if (prcntToUse == null) {
			return 0;
		}
		
		return (netTaxableIncome - prcntToUse.getTaxableValue())*prcntToUse.getPercent() + prcntToUse.getTaxDue();
	}

	public float getAnnualizedWithHoldingTax(float annualTaxableIncome, TaxStatus taxStatus, int year, String taxDistribution) {
		LoadTaxProperties<TaxExemption> taxProp = new LoadTaxProperties<TaxExemption>(TaxExemption.class);
		TaxExemption tax = taxProp.loadTaxProperties(this.mapper, new File(TAXABLE_EXEMPTION));
		float taxExempt = 0.0f;
		
		for(Map.Entry<TaxStatus, Float> mapEntry : tax.getExemptionList().entrySet()) {
			if (mapEntry.getKey().equals(taxStatus)) {
				taxExempt = mapEntry.getValue();
				break;
			}
		}
		
		return this.getWithHoldingTax(annualTaxableIncome - taxExempt, taxStatus, year, taxDistribution);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		TaxScheme taxScheme = new TaxScheme();
		float x = taxScheme.getWithHoldingTax(67000, TaxStatus.SME, 2018, "MONTHLY");
		
		System.out.println(x);
	}
}