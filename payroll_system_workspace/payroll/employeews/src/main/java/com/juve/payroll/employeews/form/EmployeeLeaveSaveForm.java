package com.juve.payroll.employeews.form;

import java.util.Calendar;

public class EmployeeLeaveSaveForm {
	private Long id;
	private Long employeeId;
	private Long leaveType;
	
	private Calendar renderedDate;
	private int renderedHour;
	private String description;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public Long getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(Long leaveType) {
		this.leaveType = leaveType;
	}
	public Calendar getRenderedDate() {
		return renderedDate;
	}
	public void setRenderedDate(Calendar renderedDate) {
		this.renderedDate = renderedDate;
	}
	public int getRenderedHour() {
		return renderedHour;
	}
	public void setRenderedHour(int renderedHour) {
		this.renderedHour = renderedHour;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
