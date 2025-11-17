// File: src/main/java/com/mobinyousefi/cabbooking/repository/impl/RideRepositoryImpl.java
package com.mobinyousefi.cabbooking.repository.impl;

import com.mobinyousefi.cabbooking.model.Ride;
import com.mobinyousefi.cabbooking.repository.RideRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RideRepositoryImpl extends GenericDaoImpl<Ride, Long> implements RideRepository {
}
