package com.juve.payroll.service;

import java.util.List;

import com.juve.payroll.model.Employee;

public interface IEmployeeService extends IGenericPayrollService<Employee> {
	public Employee getEmployeeByEmployeeId(String employeeId);
	public List<Employee> getEmployeesByClientId(Long clientId);
	public List<Employee> getReporteesOfEmployee(Long employeeId);
}
