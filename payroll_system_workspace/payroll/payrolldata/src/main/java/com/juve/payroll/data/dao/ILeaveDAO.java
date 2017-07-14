package com.juve.payroll.data.dao;

import java.util.List;

import com.juve.payroll.model.Leave;

public interface ILeaveDAO extends IPayrollGenericDAO<Leave> {
	List<Leave> getLeaves();
}
