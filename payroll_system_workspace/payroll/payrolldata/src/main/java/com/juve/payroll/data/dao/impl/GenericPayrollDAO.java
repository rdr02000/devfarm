package com.juve.payroll.data.dao.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.config.BeanDefinition;

import com.juve.payroll.data.dao.IPayrollGenericDAO;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class GenericPayrollDAO<T extends Serializable > extends AbstractPayrollDAO<T> implements IPayrollGenericDAO<T> {

}
