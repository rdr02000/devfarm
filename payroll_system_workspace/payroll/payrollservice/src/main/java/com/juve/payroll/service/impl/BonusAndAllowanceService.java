package com.juve.payroll.service.impl;

import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.model.BonusAndAllowance;
import com.juve.payroll.service.IBonusAndAllowanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BonusAndAllowanceService extends AbstractPayrollGenericService<BonusAndAllowance> implements IBonusAndAllowanceService {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<BonusAndAllowance> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(BonusAndAllowance.class);
	}
}
