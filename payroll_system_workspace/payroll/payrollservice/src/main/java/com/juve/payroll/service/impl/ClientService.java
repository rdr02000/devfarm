package com.juve.payroll.service.impl;

import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.model.Client;
import com.juve.payroll.service.IClientService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractPayrollGenericService<Client> implements IClientService {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<Client> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(Client.class);
	}
	
	public Client getClientDetails(Long clientId) {
		return genericPayrollDAO.findOne(clientId);
	}
}
