package com.juve.payroll.service.impl;

import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.model.EmployeeShift;
import com.juve.payroll.service.IEmployeeShiftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeShiftService extends AbstractPayrollGenericService<EmployeeShift> implements IEmployeeShiftService {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<EmployeeShift> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(EmployeeShift.class);
	}
}
