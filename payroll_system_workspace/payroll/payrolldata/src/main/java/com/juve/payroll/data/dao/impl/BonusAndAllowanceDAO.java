package com.juve.payroll.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.juve.payroll.data.dao.IBonusAndAllowanceDAO;
import com.juve.payroll.model.BonusAndAllowance;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class BonusAndAllowanceDAO extends GenericPayrollDAO<BonusAndAllowance> implements IBonusAndAllowanceDAO {
	
	@Override
	public List<BonusAndAllowance> getBonusAndAllowances() {
		return this.findAll();
	}
}
