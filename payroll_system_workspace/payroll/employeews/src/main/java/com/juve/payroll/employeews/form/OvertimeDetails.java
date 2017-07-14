package com.juve.payroll.employeews.form;

import java.util.List;

public class OvertimeDetails {
	private Long id;
	private String employeeId;
	private String firstName;
	private String lastName;
	private List<Overtime> overtimeList;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public List<Overtime> getOvertimeList() {
		return overtimeList;
	}
	public void setOvertimeList(List<Overtime> overtimeList) {
		this.overtimeList = overtimeList;
	}
	
}
