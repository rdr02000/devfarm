package com.juve.payroll.data.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.juve.payroll.data.dao.IEmployeeOvertimeRecordDAO;
import com.juve.payroll.model.OvertimeRecord;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class EmployeeOvertimeRecordDAO extends AbstractPayrollDAO<OvertimeRecord> implements IEmployeeOvertimeRecordDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<OvertimeRecord> getEmployeesOvertime(Long employeeId,
			Date from, Date to) {
		Query query = this.entityManager.createNamedQuery("OvertimeRecord.findOvertimeByEmployeeAndDate").
				setParameter("employeeId", employeeId)
				.setParameter("from", from)
				.setParameter("to", to);
		
		return query.getResultList();
	}
}
