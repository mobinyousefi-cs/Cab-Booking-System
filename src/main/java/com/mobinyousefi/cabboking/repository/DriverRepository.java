// File: src/main/java/com/mobinyousefi/cabbooking/repository/DriverRepository.java
package com.mobinyousefi.cabbooking.repository;

import java.util.List;

import com.mobinyousefi.cabbooking.model.Driver;
import com.mobinyousefi.cabbooking.model.enums.CabType;

public interface DriverRepository extends GenericDao<Driver, Long> {

    List<Driver> findAvailableDriversByAreaAndType(String area, CabType cabType);
}
