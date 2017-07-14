package com.juve.payroll.data.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.juve.payroll.data.dao.ITimeRecordDAO;
import com.juve.payroll.model.TimeRecord;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class TimeRecordDAO extends GenericPayrollDAO<TimeRecord> implements ITimeRecordDAO {

	@Override
	public List<TimeRecord> getEmployeeTimeRecord(Long employeeId, Date timeIn,
			Date timeOut) {
		
		Query query = this.entityManager.createNamedQuery("TimeRecord.findByEmployeeIdAndTime")
				.setParameter("employeeId", employeeId)
				.setParameter("timeIn", timeIn, TemporalType.TIMESTAMP)
				.setParameter("timeOut", timeOut, TemporalType.TIMESTAMP);
		
		@SuppressWarnings("unchecked")
		List<TimeRecord> list = query.getResultList();
	
		return list;
	}
}
