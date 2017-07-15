package com.juve.payroll.service;

import java.util.List;

import com.juve.payroll.model.EmployeeAllowance;

public interface IEmployeeAllowance extends IGenericPayrollService<EmployeeAllowance> {
	public List<EmployeeAllowance> getEmployeeAllowance(long employeeId);
}
