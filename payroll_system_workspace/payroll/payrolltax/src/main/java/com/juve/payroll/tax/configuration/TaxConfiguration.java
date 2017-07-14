package com.juve.payroll.tax.configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juve.payroll.tax.constant.TaxStatus;
import com.juve.payroll.tax.model.Tax;
import com.juve.payroll.tax.model.TaxExemption;
import com.juve.payroll.tax.model.TaxStatusPercentage;

public class TaxConfiguration<T> {
	private ObjectMapper mapper;
	
	private T t;
	
	public TaxConfiguration(T t) {
		this.t = t;
		this.mapper = new ObjectMapper();
	}
	
	public void configureTaxProperties(File file) {
		try {
			mapper.writeValue(file, t);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Tax tax = new Tax();
		
		TaxStatusPercentage sme20prcnt = new TaxStatusPercentage();
		sme20prcnt.setPercent(0.20f);
		sme20prcnt.setTaxableValue(25000f);
		sme20prcnt.setTaxDue(0);
		
		TaxStatusPercentage sme25prcnt = new TaxStatusPercentage();
		sme25prcnt.setPercent(0.25f);
		sme25prcnt.setTaxableValue(37500f);
		sme25prcnt.setTaxDue(2500f);
		
		TaxStatusPercentage sme30prcnt = new TaxStatusPercentage();
		sme30prcnt.setPercent(0.30f);
		sme30prcnt.setTaxableValue(70833.33f);
		sme30prcnt.setTaxDue(10833f);
		
		TaxStatusPercentage sme32prcnt = new TaxStatusPercentage();
		sme32prcnt.setPercent(0.32f);
		sme32prcnt.setTaxableValue(170833.33f);
		sme32prcnt.setTaxDue(40833.33f);
		
		TaxStatusPercentage sme35prcnt = new TaxStatusPercentage();
		sme35prcnt.setPercent(0.35f);
		sme35prcnt.setTaxableValue(420833.33f);
		sme35prcnt.setTaxDue(120833.33f);
		
		List<TaxStatusPercentage> list = new ArrayList<TaxStatusPercentage>();
		
		list.add(sme20prcnt);
		list.add(sme25prcnt);
		list.add(sme30prcnt);
		list.add(sme32prcnt);
		list.add(sme35prcnt);
		
		tax.setTaxDistribution("MONTHLY");
		tax.setTaxStatus(TaxStatus.SME);
		tax.setTaxStatusPercentage(list);
		tax.setTaxYear(2018);
		
		/*TaxStatusPercentage annual20Prcnt = new TaxStatusPercentage();
		annual20Prcnt.setPercent(0.20f);
		annual20Prcnt.setTaxableValue(250000f);
		annual20Prcnt.setTaxDue(0.0f);
		
		TaxStatusPercentage annual25Prcnt = new TaxStatusPercentage();
		annual25Prcnt.setPercent(0.25f);
		annual25Prcnt.setTaxableValue(400000f);
		annual25Prcnt.setTaxDue(30000);
		
		
		List<TaxStatusPercentage> annualList = new ArrayList<TaxStatusPercentage>();
		annualList.add(annual20Prcnt);
		annualList.add(annual25Prcnt);
		
		Tax annualTax = new Tax();
		annualTax.setTaxDistribution("ANNUAL");
		annualTax.setTaxStatus(TaxStatus.SME);
		annualTax.setTaxYear(2018);
		annualTax.setTaxStatusPercentage(annualList);
		
		TaxExemption taxExemption = new TaxExemption();
		Map<TaxStatus, Float> exemptionList = new HashMap<TaxStatus, Float>();
		exemptionList.put(TaxStatus.SME, 50000f);
		exemptionList.put(TaxStatus.S1ME1, 75000f);
		taxExemption.setYear(2018);
		taxExemption.setExemptionList(exemptionList);
		
		TaxConfiguration<TaxExemption> taxConfiguration = new TaxConfiguration<TaxExemption>(taxExemption);
		taxConfiguration.configureTaxProperties(new File("C:\\development\\payroll_system\\payroll_system_workspace\\taxtable\\exemption.json"));*/
		
		TaxConfiguration<Tax> taxTableConfig = new TaxConfiguration<Tax>(tax);
		taxTableConfig.configureTaxProperties(new File(  "C:\\development\\payroll_system\\payroll_system_workspace\\taxtable\\tax" + tax.getTaxYear()
				+ tax.getTaxDistribution() + tax.getTaxStatus() + ".json"));
		
		
	}
}