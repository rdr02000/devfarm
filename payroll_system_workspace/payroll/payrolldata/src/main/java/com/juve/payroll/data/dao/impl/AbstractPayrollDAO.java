package com.juve.payroll.data.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class AbstractPayrollDAO<T extends Serializable> {
	
	private Class<T> clazz;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public void setClazz( Class< T > clazzToSet ) {
		this.clazz = clazzToSet;
	}
	
	@Transactional
	public void create(final T t) {
		entityManager.persist(t);
	}
	
	public T findOne(final Long id ){
		return (T) entityManager.find(clazz, id );
	}
	
	@SuppressWarnings("unchecked")
	public List< T > findAll(){
		return entityManager.createQuery( "from " + clazz.getName() ).getResultList();
	}
	
	@Transactional
	public T update(final T t) {
		return entityManager.merge(t);
	}
	
	@Transactional
	public void delete(final T t) {
		entityManager.remove(t);
	}
	
	@Transactional
	public void deleteById(final Long entityId ){
		T entity = findOne( entityId );
		delete( entity );
	}
}
