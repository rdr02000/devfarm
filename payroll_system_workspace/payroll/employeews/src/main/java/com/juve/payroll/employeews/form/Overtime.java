package com.juve.payroll.employeews.form;

public class Overtime {
	private String description;
	private String dateRendered;
	private String status;
	private int renderedHour;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateRendered() {
		return dateRendered;
	}
	public void setDateRendered(String dateRendered) {
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
