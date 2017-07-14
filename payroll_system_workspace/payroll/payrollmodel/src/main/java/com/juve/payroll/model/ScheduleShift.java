package com.juve.payroll.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the schedule_shift database table.
 * 
 */
@Entity
@Table(name="schedule_shift")
@NamedQuery(name="ScheduleShift.findAll", query="SELECT s FROM ScheduleShift s")
public class ScheduleShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="shift_name")
	private String shiftName;

	@Column(name="shift_rule")
	private String shiftRule;

	//bi-directional many-to-one association to EmployeeShift
	@OneToMany(mappedBy="scheduleShift")
	private Set<EmployeeShift> employeeShifts;

	public ScheduleShift() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShiftName() {
		return this.shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getShiftRule() {
		return this.shiftRule;
	}

	public void setShiftRule(String shiftRule) {
		this.shiftRule = shiftRule;
	}

	public Set<EmployeeShift> getEmployeeShifts() {
		return this.employeeShifts;
	}

	public void setEmployeeShifts(Set<EmployeeShift> employeeShifts) {
		this.employeeShifts = employeeShifts;
	}

	public EmployeeShift addEmployeeShift(EmployeeShift employeeShift) {
		getEmployeeShifts().add(employeeShift);
		employeeShift.setScheduleShift(this);

		return employeeShift;
	}

	public EmployeeShift removeEmployeeShift(EmployeeShift employeeShift) {
		getEmployeeShifts().remove(employeeShift);
		employeeShift.setScheduleShift(null);

		return employeeShift;
	}

}