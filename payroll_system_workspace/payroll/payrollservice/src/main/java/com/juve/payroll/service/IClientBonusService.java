package com.juve.payroll.service;

import java.util.List;

import com.juve.payroll.model.ClientOfferedAllowance;

public interface IClientBonusService extends IGenericPayrollService<ClientOfferedAllowance> {
	List<ClientOfferedAllowance> getBonusAndAllowancesByClient(Long clientId);
}
