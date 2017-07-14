package com.juve.payroll.data.dao;

import java.util.Date;
import java.util.List;

import com.juve.payroll.model.TimeRecord;

public interface ITimeRecordDAO {
	List<TimeRecord> getEmployeeTimeRecord(Long employeeId, Date timeIn, Date timeOut);
}
