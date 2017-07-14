package com.juve.payroll.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the overtime_record database table.
 * 
 */
@Entity
@Table(name="overtime_record")
@NamedQueries({ @NamedQuery(name="OvertimeRecord.findAll", query="SELECT o FROM OvertimeRecord o"),
@NamedQuery(name="OvertimeRecord.findOvertimeByEmployeeAndDate", query="SELECT o FROM OvertimeRecord o "
		+ "WHERE o.employee.id=:employeeId AND o.dateRendered >= :from AND o.dateRendered <= :to ")})

public class OvertimeRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	@Column(name="description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_rendered")
	private Date dateRendered;
	
	@Column(name="status")
	private String status;
	
	@Column(name="rendered_hour")
	private int renderedHour;


	public OvertimeRecord() {
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateRendered() {
		return this.dateRendered;
	}

	public void setDateRendered(Date timeOut) {
		this.dateRendered = timeOut;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}