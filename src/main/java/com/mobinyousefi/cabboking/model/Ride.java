// File: src/main/java/com/mobinyousefi/cabbooking/model/Ride.java
package com.mobinyousefi.cabbooking.model;

import java.time.LocalDateTime;

import com.mobinyousefi.cabbooking.model.enums.CabType;
import com.mobinyousefi.cabbooking.model.enums.RideStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String pickupArea;

    @Column(nullable = false, length = 120)
    private String dropArea;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CabType cabType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(nullable = false)
    private LocalDateTime requestedAt;

    @Column
    private Integer estimatedEtaMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RideStatus status;

    public Ride() {
    }

    public Ride(String pickupArea, String dropArea, CabType cabType, Driver driver,
                LocalDateTime requestedAt, Integer estimatedEtaMinutes, RideStatus status) {
        this.pickupArea = pickupArea;
        this.dropArea = dropArea;
        this.cabType = cabType;
        this.driver = driver;
        this.requestedAt = requestedAt;
        this.estimatedEtaMinutes = estimatedEtaMinutes;
        this.status = status;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getPickupArea() {
        return pickupArea;
    }

    public String getDropArea() {
        return dropArea;
    }

    public CabType getCabType() {
        return cabType;
    }

    public Driver getDriver() {
        return driver;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public Integer getEstimatedEtaMinutes() {
        return estimatedEtaMinutes;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPickupArea(String pickupArea) {
        this.pickupArea = pickupArea;
    }

    public void setDropArea(String dropArea) {
        this.dropArea = dropArea;
    }

    public void setCabType(CabType cabType) {
        this.cabType = cabType;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public void setEstimatedEtaMinutes(Integer estimatedEtaMinutes) {
        this.estimatedEtaMinutes = estimatedEtaMinutes;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }
}
