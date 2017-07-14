package com.juve.payroll.data.dao;

import java.util.Date;
import java.util.List;

import com.juve.payroll.model.OvertimeRecord;

public interface IEmployeeOvertimeRecordDAO extends IPayrollGenericDAO<OvertimeRecord> {
	List<OvertimeRecord> getEmployeesOvertime(Long employeeId, Date from, Date to);
}
