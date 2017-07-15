package com.juve.payroll.employeews.form;

public class EmployeeTimeRecord {
	private String  timeIn;
	private String timeOut;
	private float late;
	private float underTime;
	private int absences;
	private float nightShiftTime;
	
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public double getLate() {
		return late;
	}
	public void setLate(float late) {
		this.late = late;
	}
	public double getUnderTime() {
		return underTime;
	}
	public void setUnderTime(float underTime) {
		this.underTime = underTime;
	}
	public int getAbsences() {
		return absences;
	}
	public void setAbsences(int absences) {
		this.absences = absences;
	}
	public float getNightShiftTime() {
		return nightShiftTime;
	}
	public void setNightShiftTime(float nightShiftTime) {
		this.nightShiftTime = nightShiftTime;
	}
}
