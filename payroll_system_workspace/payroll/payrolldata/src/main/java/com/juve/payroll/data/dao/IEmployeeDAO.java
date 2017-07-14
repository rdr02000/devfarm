package com.juve.payroll.data.dao;


import java.util.List;

import com.juve.payroll.model.Employee;

public interface IEmployeeDAO extends IPayrollGenericDAO<Employee> {
	Employee getEmployeeByEmployeeId(String employeeId);
	List<Employee> getEmployeesByClientId(Long clientId);
	List<Employee> getEmployeeDirectReport(Long employeeId);
}
