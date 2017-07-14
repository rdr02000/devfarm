package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee_shift database table.
 * 
 */
@Entity
@Table(name="employee_shift")
@NamedQuery(name="EmployeeShift.findAll", query="SELECT e FROM EmployeeShift e")
public class EmployeeShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employeeShift")
	private List<Employee> employees;

	//bi-directional many-to-one association to ScheduleShift
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="schedule_shift_id")
	private ScheduleShift scheduleShift;

	//bi-directional many-to-one association to WorkdayShift
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workday_shift")
	private WorkdayShift workdayShiftBean;

	public EmployeeShift() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmployeeShift(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmployeeShift(null);

		return employee;
	}

	public ScheduleShift getScheduleShift() {
		return this.scheduleShift;
	}

	public void setScheduleShift(ScheduleShift scheduleShift) {
		this.scheduleShift = scheduleShift;
	}

	public WorkdayShift getWorkdayShiftBean() {
		return this.workdayShiftBean;
	}

	public void setWorkdayShiftBean(WorkdayShift workdayShiftBean) {
		this.workdayShiftBean = workdayShiftBean;
	}

}