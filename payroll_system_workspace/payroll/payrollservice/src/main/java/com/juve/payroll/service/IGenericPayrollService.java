package com.juve.payroll.service;

import java.io.Serializable;
import java.util.List;

public interface IGenericPayrollService<T extends Serializable> {
	void create(final T entity);
	
	T findOne(final Long id);
	
	List<T> findAll();
	
	T update(final T entity);
	
	void delete(final T entity);
	
	void deleteById(final Long entityId);
}
