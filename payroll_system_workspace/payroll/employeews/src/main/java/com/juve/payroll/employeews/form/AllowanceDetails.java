package com.juve.payroll.employeews.form;

import java.util.List;

public class AllowanceDetails {
<<<<<<< HEAD
	private long employeeId;
=======
	private String employeeId;
>>>>>>> 52fca8eec3635ab310370236e1c80aca7322d456
	private String firstName;
	private String lastName;
	private List<Allowance> allowanceList;
	
<<<<<<< HEAD
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
=======
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
>>>>>>> 52fca8eec3635ab310370236e1c80aca7322d456
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
