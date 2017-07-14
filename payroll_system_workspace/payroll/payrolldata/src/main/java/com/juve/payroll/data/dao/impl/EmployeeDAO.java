package com.juve.payroll.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.juve.payroll.data.dao.IEmployeeDAO;
import com.juve.payroll.model.Employee;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class EmployeeDAO extends GenericPayrollDAO<Employee> implements IEmployeeDAO {
	
	@Override
	public List<Employee> getEmployeesByClientId(Long clientId) {
		Query query = this.entityManager.createNamedQuery("Employee.findByClientId").
			setParameter("clientId", clientId);
		
		@SuppressWarnings("unchecked")
		List<Employee> list = query.getResultList();
		
		return list;
	}
	
	@Override
	public Employee getEmployeeByEmployeeId(String employeeId) {
		Query query = this.entityManager.createNamedQuery("Employee.findByEmployeeId").
				setParameter("employeeId", employeeId);
		
		return (Employee)query.getSingleResult();
	}
	
	public String toString(){
		return EmployeeDAO.class.getName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeDirectReport(Long employeeId) {
		Query query = this.entityManager.createNamedQuery("Employee.findDirectReportees").
				             setParameter("reportingEmployee", employeeId);
		
		return query.getResultList();	
	}
}