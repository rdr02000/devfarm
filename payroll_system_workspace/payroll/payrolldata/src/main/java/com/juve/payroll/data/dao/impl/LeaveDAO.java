package com.juve.payroll.data.dao.impl;

import java.util.List;

import com.juve.payroll.data.dao.ILeaveDAO;
import com.juve.payroll.model.Leave;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class LeaveDAO extends GenericPayrollDAO<Leave> implements ILeaveDAO {
	
	@Override
	public List<Leave> getLeaves() {
		return this.findAll();
	}
}