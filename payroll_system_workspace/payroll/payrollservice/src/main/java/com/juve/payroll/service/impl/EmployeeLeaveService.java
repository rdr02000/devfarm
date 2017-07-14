package com.juve.payroll.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.juve.payroll.data.dao.IEmployeeLeaveDAO;
import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.model.EmployeeLeave;
import com.juve.payroll.service.IEmployeeLeaveService;

import org.springframework.stereotype.Service;

@Service
public class EmployeeLeaveService extends AbstractPayrollGenericService<EmployeeLeave> implements IEmployeeLeaveService {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<EmployeeLeave> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(EmployeeLeave.class);
	}
	
	public List<EmployeeLeave> getEmployeeLeave(Long employeeId, Date from,
			Date to) {
		return ((IEmployeeLeaveDAO)genericPayrollDAO).getEmployeesLeave(employeeId, from, to);
	}

	public List<EmployeeLeave> getEmployeeLeaveByReportingEmployee(
			Long reportingEmployeeId) {
		
		return ((IEmployeeLeaveDAO)genericPayrollDAO).getEmployeeLeavesByReportingEmployee(reportingEmployeeId);
	}
}
