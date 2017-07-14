package com.juve.payroll.data.dao;

import java.util.List;

import com.juve.payroll.model.BonusAndAllowance;

public interface IBonusAndAllowanceDAO extends IPayrollGenericDAO<BonusAndAllowance>{
	List<BonusAndAllowance> getBonusAndAllowances();
}
