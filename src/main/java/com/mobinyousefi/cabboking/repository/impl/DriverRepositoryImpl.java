// File: src/main/java/com/mobinyousefi/cabbooking/repository/impl/DriverRepositoryImpl.java
package com.mobinyousefi.cabbooking.repository.impl;

import java.util.List;

import com.mobinyousefi.cabbooking.model.Driver;
import com.mobinyousefi.cabbooking.model.enums.CabType;
import com.mobinyousefi.cabbooking.repository.DriverRepository;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DriverRepositoryImpl extends GenericDaoImpl<Driver, Long> implements DriverRepository {

    @Override
    public List<Driver> findAvailableDriversByAreaAndType(String area, CabType cabType) {
        String hql = "from Driver d where d.available = true and d.cabType = :cabType and d.currentArea = :area";
        Query<Driver> query = currentSession().createQuery(hql, Driver.class);
        query.setParameter("cabType", cabType);
        query.setParameter("area", area);
        return query.getResultList();
    }
}
