package com.juve.payroll.employeews.form;

public class EmployeeLeaveDetails {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String leaveType;
	private String renderedDate;
	private int renderedHour;
	private String status;
	private String description;
	
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
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getRenderedDate() {
		return renderedDate;
	}
	public void setRenderedDate(String renderedDate) {
		this.renderedDate = renderedDate;
	}
	public int getRenderedHour() {
		return renderedHour;
	}
	public void setRenderedHour(int renderedHour) {
		this.renderedHour = renderedHour;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
