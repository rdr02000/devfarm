package com.juve.payroll.service.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juve.payroll.data.dao.IEmployeeDAO;
import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.model.Employee;
import com.juve.payroll.service.IEmployeeService;

@Service
public class EmployeeService extends AbstractPayrollGenericService<Employee> implements IEmployeeService {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<Employee> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(Employee.class);
	}
	
	public List<Employee> getEmployeesByClientId(Long clientId) {
		return ((IEmployeeDAO)genericPayrollDAO).getEmployeesByClientId(clientId);
	}

	public Employee getEmployeeByEmployeeId(String employeeId) {
		return ((IEmployeeDAO)genericPayrollDAO).getEmployeeByEmployeeId(employeeId);
	}

	public List<Employee> getReporteesOfEmployee(Long employeeId) {
		return ((IEmployeeDAO)genericPayrollDAO).getEmployeeDirectReport(employeeId);
	}
}
