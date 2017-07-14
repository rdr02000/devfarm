package com.juve.payroll.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the leave database table.
 * 
 */
@Entity
@Table(name="mydb.leave")
@NamedQueries({
@NamedQuery(name="Leave.findAll", query="SELECT c FROM Leave c"),
@NamedQuery(name="Leave.findEmployeesLeave", query = "SELECT el FROM EmployeeLeave el WHERE employee_id = :employeeId")})
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="is_with_pay")
	private byte isWithPay;

	@Column(name="leave_desc")
	private String leaveDesc;

	@Column(name="leave_name")
	private String leaveName;

	//bi-directional many-to-one association to EmployeeLeave
	@OneToMany(mappedBy="leave")
	private Set<EmployeeLeave> employeeLeaves;

	public Leave() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte getIsWithPay() {
		return this.isWithPay;
	}

	public void setIsWithPay(byte isWithPay) {
		this.isWithPay = isWithPay;
	}

	public String getLeaveDesc() {
		return this.leaveDesc;
	}

	public void setLeaveDesc(String leaveDesc) {
		this.leaveDesc = leaveDesc;
	}

	public String getLeaveName() {
		return this.leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public Set<EmployeeLeave> getEmployeeLeaves() {
		return this.employeeLeaves;
	}

	public void setEmployeeLeaves(Set<EmployeeLeave> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}

	public EmployeeLeave addEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().add(employeeLeave);
		employeeLeave.setLeave(this);

		return employeeLeave;
	}

	public EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().remove(employeeLeave);
		employeeLeave.setLeave(null);

		return employeeLeave;
	}
}