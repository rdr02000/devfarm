package com.juve.payroll.data.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.juve.payroll.data.dao.IEmployeeLeaveDAO;
import com.juve.payroll.model.EmployeeLeave;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class EmployeeLeaveDAO extends GenericPayrollDAO<EmployeeLeave> implements IEmployeeLeaveDAO {

	@SuppressWarnings("unchecked")
	public List<EmployeeLeave> getEmployeesLeave(Long employeeId, Date from, Date to) {
		Query query = this.entityManager.createNamedQuery("EmployeeLeave.findLeaveByEmplyeeId").
				setParameter("employeeId", employeeId).
				setParameter("from", from).
				setParameter("to", to);
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeLeave> getEmployeeLeavesByReportingEmployee(Long reportingEmployeeId) {
		
		Query query = this.entityManager.createNamedQuery("EmployeeLeave.findLeaveByReportees").
				setParameter("reportingEmployeeId", reportingEmployeeId);
		
		return query.getResultList();
	}
}
