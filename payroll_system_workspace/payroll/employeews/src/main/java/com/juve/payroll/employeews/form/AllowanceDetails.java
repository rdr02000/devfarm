package com.juve.payroll.employeews.form;

import java.util.List;

public class AllowanceDetails {
	private String employeeId;
	private String firstName;
	private String lastName;
	private List<Allowance> allowanceList;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Allowance> getAllowanceList() {
		return allowanceList;
	}
	public void setAllowanceList(List<Allowance> allowanceList) {
		this.allowanceList = allowanceList;
	}
}
