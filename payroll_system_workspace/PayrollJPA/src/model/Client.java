package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private int id;

	@Column(name="client_address")
	private String clientAddress;

	@Column(name="client_contact_num")
	private String clientContactNum;

	@Column(name="client_contact_person")
	private String clientContactPerson;

	@Column(name="client_name")
	private String clientName;

	//bi-directional many-to-one association to ClientOfferedAllowance
	@OneToMany(mappedBy="client")
	private List<ClientOfferedAllowance> clientOfferedAllowances;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="client")
	private List<Employee> employees;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public List<ClientOfferedAllowance> getClientOfferedAllowances() {
		return this.clientOfferedAllowances;
	}

	public void setClientOfferedAllowances(List<ClientOfferedAllowance> clientOfferedAllowances) {
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

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
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