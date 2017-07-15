package com.juve.payroll.employeews.form;

import java.util.List;

public class EmployeeTimeRecordDetail {
	private String employeeId;
	private String firstName;
	private String lastName;
	private List<EmployeeTimeRecord> employeeTimeRecordList;
	private long late;
	private long underTime;
	private int absences;
	private long nightShift;
	
	public List<EmployeeTimeRecord> getEmployeeTimeRecordList() {
		return employeeTimeRecordList;
	}
	public void setEmployeeTimeRecordList(
			List<EmployeeTimeRecord> employeeTimeRecordList) {
		this.employeeTimeRecordList = employeeTimeRecordList;
	}
	public double getLate() {
		return late;
	}
	public void setLate(long late) {
		this.late = late;
	}
	public double getUnderTime() {
		return underTime;
	}
	public void setUnderTime(long underTime) {
		this.underTime = underTime;
	}
	public int getAbsences() {
		return absences;
	}
	public void setAbsences(int absences) {
		this.absences = absences;
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
	public double getNightShift() {
		return nightShift;
	}
	public void setNightShift(long nightShift) {
		this.nightShift = nightShift;
	}
}
