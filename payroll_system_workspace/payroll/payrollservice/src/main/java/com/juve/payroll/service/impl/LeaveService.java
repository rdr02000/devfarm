package com.juve.payroll.service.impl;

import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.model.Leave;
import com.juve.payroll.service.ILeaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService extends AbstractPayrollGenericService<Leave> implements ILeaveService {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<Leave> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(Leave.class);
	}
}
