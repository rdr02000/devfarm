package com.juve.payroll.data.dao;

import java.util.List;

import com.juve.payroll.model.EmployeeAllowance;

public interface IEmployeeAllowanceDAO extends IPayrollGenericDAO<EmployeeAllowance> {
	List<EmployeeAllowance> getEmployeeAllowance(Long employeeId);
}
