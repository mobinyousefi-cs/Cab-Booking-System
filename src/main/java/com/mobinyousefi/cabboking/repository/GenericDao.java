// File: src/main/java/com/mobinyousefi/cabbooking/repository/GenericDao.java
package com.mobinyousefi.cabbooking.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

    T findById(ID id);

    List<T> findAll();

    T save(T entity);

    void delete(T entity);
}
