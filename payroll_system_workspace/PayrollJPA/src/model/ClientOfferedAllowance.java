package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client_offered_allowance database table.
 * 
 */
@Entity
@Table(name="client_offered_allowance")
@NamedQuery(name="ClientOfferedAllowance.findAll", query="SELECT c FROM ClientOfferedAllowance c")
public class ClientOfferedAllowance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to BonusAndAllowance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bonus_and_allowance_id")
	private BonusAndAllowance bonusAndAllowance;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	private Client client;

	//bi-directional many-to-one association to EmployeeAllowance
	@OneToMany(mappedBy="clientOfferedAllowanceBean")
	private List<EmployeeAllowance> employeeAllowances;

	public ClientOfferedAllowance() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BonusAndAllowance getBonusAndAllowance() {
		return this.bonusAndAllowance;
	}

	public void setBonusAndAllowance(BonusAndAllowance bonusAndAllowance) {
		this.bonusAndAllowance = bonusAndAllowance;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<EmployeeAllowance> getEmployeeAllowances() {
		return this.employeeAllowances;
	}

	public void setEmployeeAllowances(List<EmployeeAllowance> employeeAllowances) {
		this.employeeAllowances = employeeAllowances;
	}

	public EmployeeAllowance addEmployeeAllowance(EmployeeAllowance employeeAllowance) {
		getEmployeeAllowances().add(employeeAllowance);
		employeeAllowance.setClientOfferedAllowanceBean(this);

		return employeeAllowance;
	}

	public EmployeeAllowance removeEmployeeAllowance(EmployeeAllowance employeeAllowance) {
		getEmployeeAllowances().remove(employeeAllowance);
		employeeAllowance.setClientOfferedAllowanceBean(null);

		return employeeAllowance;
	}

}