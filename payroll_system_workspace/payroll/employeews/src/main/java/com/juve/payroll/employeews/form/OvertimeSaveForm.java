package com.juve.payroll.employeews.form;

import java.util.Calendar;

public class OvertimeSaveForm {
	private Long id;
	private Long employeeId;
	private String description;
	private Calendar dateRendered;
	private String status;
	private int renderedHour;
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Calendar getDateRendered() {
		return dateRendered;
	}
	public void setDateRendered(Calendar dateRendered) {
		this.dateRendered = dateRendered;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRenderedHour() {
		return renderedHour;
	}
	public void setRenderedHour(int renderedHour) {
		this.renderedHour = renderedHour;
	} 
}
