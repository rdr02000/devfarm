package com.juve.payroll.service;

import com.juve.payroll.model.Client;

public interface IClientService extends IGenericPayrollService<Client> {
	Client getClientDetails(Long clientId);
}
