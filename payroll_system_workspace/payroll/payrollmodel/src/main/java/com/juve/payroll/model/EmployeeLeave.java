package com.juve.payroll.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the employee_leave database table.
 * 
 */
@Entity
@Table(name="employee_leave")
@NamedQueries({@NamedQuery(name="EmployeeLeave.findAll", query="SELECT e FROM EmployeeLeave e"),
@NamedQuery(name="EmployeeLeave.findLeaveByEmplyeeId", query="SELECT e FROM EmployeeLeave e WHERE e.employee.id=:employeeId AND e.renderedDate>=:from AND e.renderedDate <= :to "),
@NamedQuery(name="EmployeeLeave.findLeaveByReportees", query="SELECT e FROM EmployeeLeave e WHERE e.employee.reportingEmployee.id=:reportingEmployeeId AND e.employee.reportingEmployee.id <> e.employee.id AND status='pending'")})

public class EmployeeLeave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="rendered_date")
	private Date renderedDate;

	@Column(name="rendered_hours")
	private int renderedHours;
	
	@Column(name="status")
	private String status;
	
	@Column(name="description")
	private String description;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	//bi-directional many-to-one association to Leave
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="leave_type")
	private Leave leave;

	public EmployeeLeave() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}

	public Date getRenderedDate() {
		return this.renderedDate;
	}

	public void setRenderedDate(Date renderedDate) {
		this.renderedDate = renderedDate;
	}

	public int getRenderedHours() {
		return this.renderedHours;
	}

	public void setRenderedHours(int renderedHours) {
		this.renderedHours = renderedHours;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Leave getLeave() {
		return this.leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}
}