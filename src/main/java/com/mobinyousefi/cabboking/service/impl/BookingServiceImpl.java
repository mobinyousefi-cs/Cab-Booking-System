// File: src/main/java/com/mobinyousefi/cabbooking/service/impl/BookingServiceImpl.java
package com.mobinyousefi.cabbooking.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.mobinyousefi.cabbooking.dto.RideSearchRequest;
import com.mobinyousefi.cabbooking.exception.ResourceNotFoundException;
import com.mobinyousefi.cabbooking.model.Driver;
import com.mobinyousefi.cabbooking.model.Ride;
import com.mobinyousefi.cabbooking.model.enums.RideStatus;
import com.mobinyousefi.cabbooking.repository.DriverRepository;
import com.mobinyousefi.cabbooking.repository.RideRepository;
import com.mobinyousefi.cabbooking.service.BookingService;
import com.mobinyousefi.cabbooking.util.EtaCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final DriverRepository driverRepository;
    private final RideRepository rideRepository;

    @Autowired
    public BookingServiceImpl(DriverRepository driverRepository, RideRepository rideRepository) {
        this.driverRepository = driverRepository;
        this.rideRepository = rideRepository;
    }

    @Override
    public Ride searchAndPrepareRide(RideSearchRequest request) {
        List<Driver> drivers =
                driverRepository.findAvailableDriversByAreaAndType(request.getPickupArea(), request.getCabType());

        if (drivers.isEmpty()) {
            throw new ResourceNotFoundException("No available drivers found near " + request.getPickupArea());
        }

        // For MVP: select the first available driver
        Driver selectedDriver = drivers.get(0);

        int eta = EtaCalculator.estimateEtaMinutes(request.getPickupArea(), request.getDropArea());

        Ride ride = new Ride(
                request.getPickupArea(),
                request.getDropArea(),
                request.getCabType(),
                selectedDriver,
                LocalDateTime.now(),
                eta,
                RideStatus.REQUESTED
        );

        return rideRepository.save(ride);
    }

    @Override
    public Ride confirmRide(Long rideId) {
        Ride ride = rideRepository.findById(rideId);
        if (ride == null) {
            throw new ResourceNotFoundException("Ride with id " + rideId + " not found");
        }

        ride.setStatus(RideStatus.CONFIRMED);

        // Mark driver as not available
        Driver driver = ride.getDriver();
        if (driver != null) {
            driver.setAvailable(false);
        }

        return rideRepository.save(ride);
    }
}
