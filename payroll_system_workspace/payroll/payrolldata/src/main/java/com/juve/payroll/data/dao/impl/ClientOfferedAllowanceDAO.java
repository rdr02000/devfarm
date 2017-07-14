package com.juve.payroll.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.juve.payroll.data.dao.IClientOfferedAllowanceDAO;
import com.juve.payroll.model.ClientOfferedAllowance;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class ClientOfferedAllowanceDAO extends GenericPayrollDAO<ClientOfferedAllowance> implements IClientOfferedAllowanceDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientOfferedAllowance> getClientOfferedAllowanceByClientId(
			Long clientId) {
		Query query = this.entityManager.createNamedQuery("ClientOfferedAllowance.findByClientId").
				setParameter("clientId", clientId);
				
		return query.getResultList();
	}
}
