package com.juve.payroll.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import com.juve.payroll.data.dao.IPayrollGenericDAO;

public abstract class AbstractPayrollGenericService<T extends Serializable> {
	IPayrollGenericDAO<T> genericPayrollDAO;
	
	@Transactional
	public void create(T t) {
		genericPayrollDAO.create(t);
	}
	
	public T findOne(Long id) {
		return genericPayrollDAO.findOne(id);
	}
	
	public void delete(T t) {
		genericPayrollDAO.delete(t);
	}
	
	public void deleteById(Long entityId) {
		genericPayrollDAO.deleteById(entityId);
	}
	
	public List<T> findAll() {
		return genericPayrollDAO.findAll();
	} 
	
	public T get(Long id) {
		return genericPayrollDAO.findOne(id);
	}
	
	public T update(T t) {
		return genericPayrollDAO.update(t);
	}
}
