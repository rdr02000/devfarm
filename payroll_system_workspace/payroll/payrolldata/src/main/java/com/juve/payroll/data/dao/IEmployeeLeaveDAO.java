package com.juve.payroll.data.dao;

import java.util.Date;
import java.util.List;

import com.juve.payroll.model.EmployeeLeave;

public interface IEmployeeLeaveDAO extends IPayrollGenericDAO<EmployeeLeave> {
	List<EmployeeLeave> getEmployeesLeave(Long employeeId, Date from, Date to);
	List<EmployeeLeave> getEmployeeLeavesByReportingEmployee(Long reportingEmployeeId);
}
