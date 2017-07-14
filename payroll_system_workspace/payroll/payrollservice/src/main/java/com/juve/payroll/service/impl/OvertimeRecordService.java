package com.juve.payroll.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.data.dao.IEmployeeOvertimeRecordDAO;
import com.juve.payroll.model.OvertimeRecord;
import com.juve.payroll.service.IOvertimeRecordService;

@Service
public class OvertimeRecordService extends AbstractPayrollGenericService<OvertimeRecord> implements IOvertimeRecordService {
	@Autowired
	public void setDAO(IPayrollGenericDAO<OvertimeRecord> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(OvertimeRecord.class);
	}

	public List<OvertimeRecord> getOvertimes(Long employeeId, Date from, Date to) {
		return ((IEmployeeOvertimeRecordDAO)genericPayrollDAO).getEmployeesOvertime(employeeId, from, to);
	}
}
