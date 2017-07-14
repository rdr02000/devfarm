package com.juve.payroll.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the time_record database table.
 * 
 */
@Entity
@Table(name="time_record")
@NamedQueries({@NamedQuery(name="TimeRecord.findAll", query="SELECT t FROM TimeRecord t"),
	@NamedQuery(name="TimeRecord.findByEmployeeIdAndTime", query="SELECT t FROM TimeRecord t WHERE t.employee.id=:employeeId AND t.timeIn>=:timeIn AND t.timeOut <= :timeOut")
})
public class TimeRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_in")
	private Date timeIn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_out")
	private Date timeOut;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	public TimeRecord() {
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}

	public Date getTimeIn() {
		return this.timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeOut() {
		return this.timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}