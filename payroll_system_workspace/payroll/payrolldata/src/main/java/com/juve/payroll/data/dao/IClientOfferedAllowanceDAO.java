package com.juve.payroll.data.dao;

import java.util.List;

import com.juve.payroll.model.ClientOfferedAllowance;

public interface IClientOfferedAllowanceDAO extends IPayrollGenericDAO<ClientOfferedAllowance> {
	List<ClientOfferedAllowance> getClientOfferedAllowanceByClientId(Long clientId);
}
