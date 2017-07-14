package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the leave database table.
 * 
 */
@Entity
@NamedQuery(name="Leave.findAll", query="SELECT l FROM Leave l")
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="is_with_pay")
	private byte isWithPay;

	@Column(name="leave_desc")
	private String leaveDesc;

	@Column(name="leave_name")
	private String leaveName;

	//bi-directional many-to-one association to EmployeeLeave
	@OneToMany(mappedBy="leave")
	private List<EmployeeLeave> employeeLeaves;

	public Leave() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public List<EmployeeLeave> getEmployeeLeaves() {
		return this.employeeLeaves;
	}

	public void setEmployeeLeaves(List<EmployeeLeave> employeeLeaves) {
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