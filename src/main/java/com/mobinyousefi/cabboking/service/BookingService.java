// File: src/main/java/com/mobinyousefi/cabbooking/service/BookingService.java
package com.mobinyousefi.cabbooking.service;

import com.mobinyousefi.cabbooking.dto.RideSearchRequest;
import com.mobinyousefi.cabbooking.model.Ride;

public interface BookingService {

    Ride searchAndPrepareRide(RideSearchRequest request);

    Ride confirmRide(Long rideId);
}
