package com.juve.payroll.service;

import java.util.Date;
import java.util.List;

import com.juve.payroll.model.OvertimeRecord;

public interface IOvertimeRecordService extends IGenericPayrollService<OvertimeRecord> {
	public List<OvertimeRecord> getOvertimes(Long id, Date from, Date to);
}
