package com.juve.payroll.service;

import java.util.Date;
import java.util.List;

import com.juve.payroll.model.TimeRecord;
import com.juve.payroll.service.model.ExcelTimeRecord;

public interface IEmployeeTimeRecordService extends IGenericPayrollService<TimeRecord>, IExcelProcessorService<ExcelTimeRecord> {
	List<TimeRecord> getEmployeeTimeRecord(Long employeeId, Date from , Date to);
	List<TimeRecord> getEmployeeTimeRecord(Long employeeId, Date date);
}
