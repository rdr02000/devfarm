package com.juve.payroll.clientws.form;

public class EmployeeSaveForm {
	private Long id;
	private String address;
	private String contactNumber;
	private Double dailySalaryRate;
	private String employeeId;
	private String firstName;
	private String hdmfId;
	private String lastName;
	private String position;
	private String sssId;
	private String status;
	private String taxId;
	
	private Long clientId;
	private Long shiftId;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Double getDailySalaryRate() {
		return dailySalaryRate;
	}
	public void setDailySalaryRate(Double dailySalaryRate) {
		this.dailySalaryRate = dailySalaryRate;
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
	public String getHdmfId() {
		return hdmfId;
	}
	public void setHdmfId(String hdmfId) {
		this.hdmfId = hdmfId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSssId() {
		return sssId;
	}
	public void setSssId(String sssId) {
		this.sssId = sssId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
}
