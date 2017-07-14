package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employee_allowance database table.
 * 
 */
@Entity
@Table(name="employee_allowance")
@NamedQuery(name="EmployeeAllowance.findAll", query="SELECT e FROM EmployeeAllowance e")
public class EmployeeAllowance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to ClientOfferedAllowance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_offered_allowance")
	private ClientOfferedAllowance clientOfferedAllowanceBean;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	private Employee employee;

	public EmployeeAllowance() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClientOfferedAllowance getClientOfferedAllowanceBean() {
		return this.clientOfferedAllowanceBean;
	}

	public void setClientOfferedAllowanceBean(ClientOfferedAllowance clientOfferedAllowanceBean) {
		this.clientOfferedAllowanceBean = clientOfferedAllowanceBean;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}