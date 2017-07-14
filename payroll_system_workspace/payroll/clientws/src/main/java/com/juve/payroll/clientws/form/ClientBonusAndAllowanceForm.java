package com.juve.payroll.clientws.form;

public class ClientBonusAndAllowanceForm {
	private String bonusName;
	private Double amount;
	private String bonusAllocation;
	
	public String getBonusName() {
		return bonusName;
	}
	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getBonusAllocation() {
		return bonusAllocation;
	}
	public void setBonusAllocation(String bonusAllocation) {
		this.bonusAllocation = bonusAllocation;
	}
}
