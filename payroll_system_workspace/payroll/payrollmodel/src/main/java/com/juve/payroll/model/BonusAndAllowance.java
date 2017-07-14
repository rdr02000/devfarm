package com.juve.payroll.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the bonus_and_allowance database table.
 * 
 */
@Entity
@Table(name="bonus_and_allowance")
@NamedQuery(name="BonusAndAllowance.findAll", query="SELECT b FROM BonusAndAllowance b")
public class BonusAndAllowance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="bonus_allocaction")
	private String bonusAllocaction;

	@Column(name="bonus_amount")
	private Double bonusAmount;

	@Column(name="bonus_name")
	private String bonusName;

	//bi-directional many-to-one association to ClientOfferedAllowance
	@OneToMany(mappedBy="bonusAndAllowance")
	private Set<ClientOfferedAllowance> clientOfferedAllowances;

	public BonusAndAllowance() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBonusAllocaction() {
		return this.bonusAllocaction;
	}

	public void setBonusAllocaction(String bonusAllocaction) {
		this.bonusAllocaction = bonusAllocaction;
	}

	public Double getBonusAmount() {
		return this.bonusAmount;
	}

	public void setBonusAmount(Double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public String getBonusName() {
		return this.bonusName;
	}

	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}

	public Set<ClientOfferedAllowance> getClientOfferedAllowances() {
		return this.clientOfferedAllowances;
	}

	public void setClientOfferedAllowances(Set<ClientOfferedAllowance> clientOfferedAllowances) {
		this.clientOfferedAllowances = clientOfferedAllowances;
	}

	public ClientOfferedAllowance addClientOfferedAllowance(ClientOfferedAllowance clientOfferedAllowance) {
		getClientOfferedAllowances().add(clientOfferedAllowance);
		clientOfferedAllowance.setBonusAndAllowance(this);

		return clientOfferedAllowance;
	}

	public ClientOfferedAllowance removeClientOfferedAllowance(ClientOfferedAllowance clientOfferedAllowance) {
		getClientOfferedAllowances().remove(clientOfferedAllowance);
		clientOfferedAllowance.setBonusAndAllowance(null);

		return clientOfferedAllowance;
	}

}