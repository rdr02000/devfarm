package com.juve.payroll.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.juve.payroll.data.dao.IEmployeeAllowanceDAO;
import com.juve.payroll.model.EmployeeAllowance;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class EmployeeAllowanceDAO extends GenericPayrollDAO<EmployeeAllowance> implements IEmployeeAllowanceDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeAllowance> getEmployeeAllowance(Long employeeId) {
		
		Query query = this.entityManager.createNamedQuery("EmployeeAllowance.findByEmployee").
				setParameter("employeeId", employeeId);
		
		return query.getResultList();
	}

}
