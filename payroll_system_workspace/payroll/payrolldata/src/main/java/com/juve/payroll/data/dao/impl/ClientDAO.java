package com.juve.payroll.data.dao.impl;

import com.juve.payroll.data.dao.IClientDAO;
import com.juve.payroll.model.Client;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE )
public class ClientDAO extends GenericPayrollDAO<Client> implements IClientDAO {
}
