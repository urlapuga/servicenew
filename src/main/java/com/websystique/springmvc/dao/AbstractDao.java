package com.websystique.springmvc.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}

	public void persistupdate(T entity){getSession().update(entity);}

	public List<T> getByNamedQuery(String queryName) {
		return getSession().getNamedQuery(queryName).list();
	}

	public List<T> getByNamedQueryWithParam(String queryName,String paramname,String paramValue) {
		return getSession().getNamedQuery(queryName).setString(paramname,paramValue).list();
	}

	public List<T> getByNamedQueryWithTwoParams(String queryName,String paramname,String paramValue,String paramname2,String paramValue2) {
		return getSession().getNamedQuery(queryName).setString(paramname,paramValue).setString(paramname2,paramValue2).list();
	}
}
