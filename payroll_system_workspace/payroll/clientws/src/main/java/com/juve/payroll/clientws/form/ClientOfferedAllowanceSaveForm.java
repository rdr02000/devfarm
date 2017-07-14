package com.juve.payroll.clientws.form;

public class ClientOfferedAllowanceSaveForm {
	private Long id;
	private Long clientId;
	private Long bonusAndAllowanceId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getBonusAndAllowanceId() {
		return bonusAndAllowanceId;
	}
	public void setBonusAndAllowanceId(Long bonusAndAllowanceId) {
		this.bonusAndAllowanceId = bonusAndAllowanceId;
	}
}
