package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the workday_shift database table.
 * 
 */
@Entity
@Table(name="workday_shift")
@NamedQuery(name="WorkdayShift.findAll", query="SELECT w FROM WorkdayShift w")
public class WorkdayShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="daily_shift_sched")
	private String dailyShiftSched;

	//bi-directional many-to-one association to EmployeeShift
	@OneToMany(mappedBy="workdayShiftBean")
	private List<EmployeeShift> employeeShifts;

	public WorkdayShift() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDailyShiftSched() {
		return this.dailyShiftSched;
	}

	public void setDailyShiftSched(String dailyShiftSched) {
		this.dailyShiftSched = dailyShiftSched;
	}

	public List<EmployeeShift> getEmployeeShifts() {
		return this.employeeShifts;
	}

	public void setEmployeeShifts(List<EmployeeShift> employeeShifts) {
		this.employeeShifts = employeeShifts;
	}

	public EmployeeShift addEmployeeShift(EmployeeShift employeeShift) {
		getEmployeeShifts().add(employeeShift);
		employeeShift.setWorkdayShiftBean(this);

		return employeeShift;
	}

	public EmployeeShift removeEmployeeShift(EmployeeShift employeeShift) {
		getEmployeeShifts().remove(employeeShift);
		employeeShift.setWorkdayShiftBean(null);

		return employeeShift;
	}

}