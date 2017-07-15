package com.juve.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juve.payroll.data.dao.IEmployeeAllowanceDAO;
import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.model.EmployeeAllowance;
import com.juve.payroll.service.IEmployeeAllowance;

@Service
public class EmployeeBonusAndAllowance extends AbstractPayrollGenericService<EmployeeAllowance> implements IEmployeeAllowance {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<EmployeeAllowance> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(EmployeeAllowance.class);
	}
	
	public List<EmployeeAllowance> getEmployeeAllowance(long employeeId) {
		return ((IEmployeeAllowanceDAO)genericPayrollDAO).getEmployeeAllowance(employeeId);
	}

}
