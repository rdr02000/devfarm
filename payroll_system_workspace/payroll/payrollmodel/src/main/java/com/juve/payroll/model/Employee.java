package com.juve.payroll.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e"),
@NamedQuery(name="Employee.findByClientId", query="SELECT e FROM Employee e WHERE e.client.id = :clientId"),
@NamedQuery(name="Employee.findByEmployeeId", query="SELECT e FROM Employee e WHERE e.employeeId = :employeeId"),
@NamedQuery(name="Employee.findDirectReportees", query="SELECT e FROM Employee e WHERE e.reportingEmployee.id=:reportingEmployee AND e.reportingEmployee.id != e.id")})
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String address;

	@Column(name="contact_number")
	private String contactNumber;

	@Column(name="daily_salary_rate")
	private double dailySalaryRate;

	@Column(name="employee_id")
	private String employeeId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="hdmf_id")
	private String hdmfId;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_address")
	private String emailAddress;

	private String position;

	@Column(name="sss_id")
	private String sssId;

	private String status;

	@Column(name="tax_id")
	private String taxId;
	
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name="reporting_employee")
	private Employee reportingEmployee;

	//bi-directional many-to-one association to EmployeeShift
	@ManyToOne
	@JoinColumn(name="shift_schedule_id")
	private EmployeeShift employeeShift;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to EmployeeAllowance
	@OneToMany(mappedBy="employee", fetch = FetchType.EAGER)
	private Set<EmployeeAllowance> employeeAllowances;

	//bi-directional many-to-one association to EmployeeLeave
	@OneToMany(mappedBy="employee", fetch = FetchType.EAGER)
	private Set<EmployeeLeave> employeeLeaves;

	//bi-directional many-to-one association to OvertimeRecord
	@OneToMany(mappedBy="employee",fetch = FetchType.EAGER)
	private Set<OvertimeRecord> overtimeRecords;

	//bi-directional many-to-one association to TimeRecord
	@OneToMany(mappedBy="employee",fetch = FetchType.EAGER)
	private Set<TimeRecord> timeRecords;

	public Employee() {
	}

	public Long getId() {
		return this.id;
	}
	
	public void setReportingEmployee(Employee reportingEmployee) {
		this.reportingEmployee = reportingEmployee;
	}
	
	public Employee getReportingEmployee() {
		return this.reportingEmployee;
	}
	
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getDailySalaryRate() {
		return this.dailySalaryRate;
	}

	public void setDailySalaryRate(double dailySalaryRate) {
		this.dailySalaryRate = dailySalaryRate;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHdmfId() {
		return this.hdmfId;
	}

	public void setHdmfId(String hdmfId) {
		this.hdmfId = hdmfId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSssId() {
		return this.sssId;
	}

	public void setSssId(String sssId) {
		this.sssId = sssId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTaxId() {
		return this.taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public EmployeeShift getEmployeeShift() {
		return this.employeeShift;
	}

	public void setEmployeeShift(EmployeeShift employeeShift) {
		this.employeeShift = employeeShift;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<EmployeeAllowance> getEmployeeAllowances() {
		return this.employeeAllowances;
	}

	public void setEmployeeAllowances(Set<EmployeeAllowance> employeeAllowances) {
		this.employeeAllowances = employeeAllowances;
	}

	public EmployeeAllowance addEmployeeAllowance(EmployeeAllowance employeeAllowance) {
		getEmployeeAllowances().add(employeeAllowance);
		employeeAllowance.setEmployee(this);

		return employeeAllowance;
	}

	public EmployeeAllowance removeEmployeeAllowance(EmployeeAllowance employeeAllowance) {
		getEmployeeAllowances().remove(employeeAllowance);
		employeeAllowance.setEmployee(null);

		return employeeAllowance;
	}

	public Set<EmployeeLeave> getEmployeeLeaves() {
		return this.employeeLeaves;
	}

	public void setEmployeeLeaves(Set<EmployeeLeave> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}

	public EmployeeLeave addEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().add(employeeLeave);
		employeeLeave.setEmployee(this);

		return employeeLeave;
	}

	public EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().remove(employeeLeave);
		employeeLeave.setEmployee(null);

		return employeeLeave;
	}

	public Set<OvertimeRecord> getOvertimeRecords() {
		return this.overtimeRecords;
	}

	public void setOvertimeRecords(Set<OvertimeRecord> overtimeRecords) {
		this.overtimeRecords = overtimeRecords;
	}

	public OvertimeRecord addOvertimeRecord(OvertimeRecord overtimeRecord) {
		getOvertimeRecords().add(overtimeRecord);
		overtimeRecord.setEmployee(this);

		return overtimeRecord;
	}

	public OvertimeRecord removeOvertimeRecord(OvertimeRecord overtimeRecord) {
		getOvertimeRecords().remove(overtimeRecord);
		overtimeRecord.setEmployee(null);

		return overtimeRecord;
	}

	public Set<TimeRecord> getTimeRecords() {
		return this.timeRecords;
	}

	public void setTimeRecords(Set<TimeRecord> timeRecords) {
		this.timeRecords = timeRecords;
	}

	public TimeRecord addTimeRecord(TimeRecord timeRecord) {
		getTimeRecords().add(timeRecord);
		timeRecord.setEmployee(this);

		return timeRecord;
	}

	public TimeRecord removeTimeRecord(TimeRecord timeRecord) {
		getTimeRecords().remove(timeRecord);
		timeRecord.setEmployee(null);

		return timeRecord;
	}

}