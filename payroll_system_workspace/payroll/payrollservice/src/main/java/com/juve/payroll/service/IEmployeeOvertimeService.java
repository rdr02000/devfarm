package com.juve.payroll.service;

import java.util.Date;
import java.util.List;

import com.juve.payroll.model.OvertimeRecord;

public interface IEmployeeOvertimeService extends IGenericPayrollService<OvertimeRecord> {
	List<OvertimeRecord> getOvertimeRecordList(Long employeeId, Date from, Date to);
}
