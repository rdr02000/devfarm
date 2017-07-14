package com.juve.payroll.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the client_offered_allowance database table.
 * 
 */
@Entity
@Table(name="client_offered_allowance")
@NamedQueries({
	@NamedQuery(name="ClientOfferedAllowance.findAll", query="SELECT c FROM ClientOfferedAllowance c"),
	@NamedQuery(name="ClientOfferedAllowance.findByClientId", query="SELECT c FROM ClientOfferedAllowance c WHERE c.client.id=:clientId")
})
public class ClientOfferedAllowance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	//bi-directional many-to-one association to BonusAndAllowance
	@ManyToOne
	@JoinColumn(name="bonus_and_allowance_id")
	private BonusAndAllowance bonusAndAllowance;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to EmployeeAllowance
	@OneToMany(mappedBy="clientOfferedAllowanceBean",fetch = FetchType.EAGER)
	private Set<EmployeeAllowance> employeeAllowances;

	public ClientOfferedAllowance() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public Set<EmployeeAllowance> getEmployeeAllowances() {
		return this.employeeAllowances;
	}

	public void setEmployeeAllowances(Set<EmployeeAllowance> employeeAllowances) {
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