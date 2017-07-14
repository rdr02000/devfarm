package com.juve.payroll.service;

import java.util.Date;
import java.util.List;

import com.juve.payroll.model.EmployeeLeave;

public interface IEmployeeLeaveService extends IGenericPayrollService<EmployeeLeave> {
	List<EmployeeLeave> getEmployeeLeave(Long employeeId, Date from, Date to);
	List<EmployeeLeave> getEmployeeLeaveByReportingEmployee(Long reportingEmployeeId);
}
