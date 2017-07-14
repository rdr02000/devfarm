package com.juve.payroll.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="client_address")
	private String clientAddress;

	@Column(name="client_contact_num")
	private String clientContactNum;

	@Column(name="client_contact_person")
	private String clientContactPerson;

	@Column(name="client_name")
	private String clientName;
	
	@Column(name="client_tax_id")
	private String clientTaxId;
	
	@Column(name="payroll_occurence")
	private String payrollOccurence;

	//bi-directional many-to-one association to ClientOfferedAllowance
	@OneToMany(mappedBy="client")
	private Set<ClientOfferedAllowance> clientOfferedAllowances;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="client")
	private Set<Employee> employees;

	public Client() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientAddress() {
		return this.clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientContactNum() {
		return this.clientContactNum;
	}

	public void setClientContactNum(String clientContactNum) {
		this.clientContactNum = clientContactNum;
	}

	public String getClientContactPerson() {
		return this.clientContactPerson;
	}

	public void setClientContactPerson(String clientContactPerson) {
		this.clientContactPerson = clientContactPerson;
	}
	
	public String getClientTaxId() {
		return clientTaxId;
	}

	public void setClientTaxId(String clientTaxId) {
		this.clientTaxId = clientTaxId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public void setPayrollOccurence(String payrollOccurence) {
		this.payrollOccurence = payrollOccurence;
	}
	
	public String getPayrollOccurence() {
		return this.payrollOccurence;
	}

	public Set<ClientOfferedAllowance> getClientOfferedAllowances() {
		return this.clientOfferedAllowances;
	}

	public void setClientOfferedAllowances(Set<ClientOfferedAllowance> clientOfferedAllowances) {
		this.clientOfferedAllowances = clientOfferedAllowances;
	}

	public ClientOfferedAllowance addClientOfferedAllowance(ClientOfferedAllowance clientOfferedAllowance) {
		getClientOfferedAllowances().add(clientOfferedAllowance);
		clientOfferedAllowance.setClient(this);

		return clientOfferedAllowance;
	}

	public ClientOfferedAllowance removeClientOfferedAllowance(ClientOfferedAllowance clientOfferedAllowance) {
		getClientOfferedAllowances().remove(clientOfferedAllowance);
		clientOfferedAllowance.setClient(null);

		return clientOfferedAllowance;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setClient(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setClient(null);

		return employee;
	}

}