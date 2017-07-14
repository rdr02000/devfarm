package com.juve.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.juve.payroll.model.ClientOfferedAllowance;
import com.juve.payroll.service.IClientBonusService;
import com.juve.payroll.data.dao.IClientOfferedAllowanceDAO;
import com.juve.payroll.data.dao.IPayrollGenericDAO;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class ClientBonusService extends AbstractPayrollGenericService<ClientOfferedAllowance> implements IClientBonusService {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<ClientOfferedAllowance> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(ClientOfferedAllowance.class);
	}
	
	public List<ClientOfferedAllowance> getBonusAndAllowancesByClient(Long clientId) {
		return ((IClientOfferedAllowanceDAO)genericPayrollDAO).getClientOfferedAllowanceByClientId(clientId);
	}
}
