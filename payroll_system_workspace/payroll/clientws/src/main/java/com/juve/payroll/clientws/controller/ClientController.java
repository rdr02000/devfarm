package com.juve.payroll.clientws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juve.payroll.clientws.form.ClientBonusAndAllowanceForm;
import com.juve.payroll.clientws.form.ClientForm;
import com.juve.payroll.clientws.form.ClientOfferedAllowanceSaveForm;
import com.juve.payroll.clientws.form.EmployeeDetailForm;
import com.juve.payroll.clientws.form.EmployeeSaveForm;
import com.juve.payroll.model.BonusAndAllowance;
import com.juve.payroll.model.Client;
import com.juve.payroll.model.ClientOfferedAllowance;
import com.juve.payroll.model.Employee;
import com.juve.payroll.model.EmployeeShift;
import com.juve.payroll.service.IBonusAndAllowanceService;
import com.juve.payroll.service.IClientBonusService;
import com.juve.payroll.service.IClientService;
import com.juve.payroll.service.IEmployeeService;
import com.juve.payroll.service.IEmployeeShiftService;
import com.juve.payroll.service.IGenericPayrollService;

@RestController
public class ClientController {
	@Autowired
	private IGenericPayrollService<Employee> employeeService;
	
	@Autowired
	private IClientBonusService clientBonusService;
	
	@Autowired
	private IClientService clientService;
	
	@Autowired 
	IEmployeeShiftService employeeShiftService;
	
	@Autowired
	IBonusAndAllowanceService bonusAndAllowanceService;
	
	@RequestMapping(value = "/client/save/employee", 
			method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EmployeeSaveForm> saveEmployee(@RequestBody EmployeeSaveForm employeeSaveForm) {
		Client client = clientService.getClientDetails(employeeSaveForm.getClientId());
		EmployeeShift shift = employeeShiftService.findOne(employeeSaveForm.getShiftId());
		
		Employee employee = new Employee();
		employee.setAddress(employeeSaveForm.getAddress());
		employee.setClient(client);
		employee.setContactNumber(employeeSaveForm.getContactNumber());
		employee.setDailySalaryRate(employeeSaveForm.getDailySalaryRate());
		employee.setEmployeeShift(shift);
		employee.setFirstName(employeeSaveForm.getFirstName());
		employee.setHdmfId(employeeSaveForm.getHdmfId());
		employee.setLastName(employeeSaveForm.getLastName());
		employee.setPosition(employeeSaveForm.getPosition());
		employee.setSssId(employeeSaveForm.getSssId());
		employee.setStatus(employeeSaveForm.getStatus());
		employee.setTaxId(employeeSaveForm.getTaxId());
		employee.setEmployeeId(employeeSaveForm.getEmployeeId());
		
		employeeService.create(employee);
		
		employeeSaveForm.setId(employee.getId());
		
		return new ResponseEntity<EmployeeSaveForm>(employeeSaveForm, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/client/save/offeredAllowance", 
			method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ClientOfferedAllowanceSaveForm> saveOfferedAllowance(@RequestBody ClientOfferedAllowanceSaveForm form ) {
		Client client = clientService.findOne(form.getClientId());
		BonusAndAllowance bonusAndAllowance = bonusAndAllowanceService.findOne(form.getBonusAndAllowanceId());
		
		ClientOfferedAllowance offeredAllowance = new ClientOfferedAllowance();
		
		offeredAllowance.setBonusAndAllowance(bonusAndAllowance);
		offeredAllowance.setClient(client);
		
		clientBonusService.create(offeredAllowance);
		
		form.setId(offeredAllowance.getId());
		
		return new ResponseEntity<ClientOfferedAllowanceSaveForm>(form, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/client/employees/{clientId}", 
			method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<EmployeeDetailForm>> getEmployeeByClient(@PathVariable("clientId")Long clientId) {
		List<Employee> employees = ((IEmployeeService)employeeService).getEmployeesByClientId(clientId);
		List<EmployeeDetailForm> retList = new ArrayList<EmployeeDetailForm>();
		
		for (Employee employee : employees ) {
			EmployeeDetailForm employeeForm = new EmployeeDetailForm();
			employeeForm.setEmployeeId(employee.getEmployeeId());
			employeeForm.setCompanyName(employee.getClient().getClientName());
			employeeForm.setAddress(employee.getAddress());
			employeeForm.setContactNumber(employee.getContactNumber());
			employeeForm.setDailyRate(employee.getDailySalaryRate());
			employeeForm.setHdmfId(employee.getHdmfId());
			employeeForm.setName(employee.getFirstName() + " " + employee.getLastName());
			employeeForm.setPosition(employee.getPosition());
			employeeForm.setShiftSchedule(employee.getEmployeeShift().getScheduleShift().getShiftName());
			employeeForm.setSssId(employee.getSssId());
			employeeForm.setStatus(employee.getStatus());
			employeeForm.setTaxId(employee.getTaxId());
			
			retList.add(employeeForm);
		}
		
		return new ResponseEntity<List<EmployeeDetailForm>>(retList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/client/bonuses/{clientId}", 
			method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<ClientBonusAndAllowanceForm>> getClientBonus(@PathVariable("clientId")Long clientId){
		List<ClientOfferedAllowance> clientBonuses = clientBonusService.getBonusAndAllowancesByClient(clientId);
		List<ClientBonusAndAllowanceForm> retList = new ArrayList<ClientBonusAndAllowanceForm>();
		
		for (ClientOfferedAllowance offeredAllowance : clientBonuses) {
			ClientBonusAndAllowanceForm form = new ClientBonusAndAllowanceForm();
			form.setAmount(offeredAllowance.getBonusAndAllowance().getBonusAmount());
			form.setBonusAllocation(offeredAllowance.getBonusAndAllowance().getBonusAllocaction());
			form.setBonusName(offeredAllowance.getBonusAndAllowance().getBonusName());
			
			retList.add(form);
		}
		
		return new ResponseEntity<List<ClientBonusAndAllowanceForm>>(retList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/client/{clientId}", 
			method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ClientForm> getClientDetails(@PathVariable("clientId")Long clientId) {
		Client client = clientService.getClientDetails(clientId);
		ClientForm form = new ClientForm();
		form.setAddress(client.getClientAddress());
		form.setClientName(client.getClientName());
		form.setContactNumber(client.getClientContactNum());
		form.setContactPerson(client.getClientContactPerson());
		form.setTaxId(client.getClientTaxId());
		
		return new ResponseEntity<ClientForm>(form, HttpStatus.FOUND);
	}
}
