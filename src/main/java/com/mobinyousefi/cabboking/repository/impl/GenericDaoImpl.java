// File: src/main/java/com/mobinyousefi/cabbooking/repository/impl/GenericDaoImpl.java
package com.mobinyousefi.cabbooking.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.mobinyousefi.cabbooking.repository.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    @Autowired
    protected SessionFactory sessionFactory;

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    protected GenericDaoImpl() {
        this.persistentClass = (Class<T>)
                ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T findById(ID id) {
        return currentSession().get(persistentClass, id);
    }

    @Override
    public List<T> findAll() {
        String hql = "from " + persistentClass.getSimpleName();
        return currentSession().createQuery(hql, persistentClass).getResultList();
    }

    @Override
    public T save(T entity) {
        currentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        currentSession().delete(entity);
    }
}
