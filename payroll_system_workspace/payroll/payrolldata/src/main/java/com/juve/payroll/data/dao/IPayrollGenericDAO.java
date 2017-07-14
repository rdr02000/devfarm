package com.juve.payroll.data.dao;

import java.io.Serializable;
import java.util.List;

public interface IPayrollGenericDAO<T extends Serializable> {
	void setClazz(Class< T > clazzToSet);
	
	void create(final T entity);
	
	T findOne(final Long id);
	
	List<T> findAll();
	
	T update(final T entity);
	
	void delete(final T entity);
	
	void deleteById(final Long entityId);
}
