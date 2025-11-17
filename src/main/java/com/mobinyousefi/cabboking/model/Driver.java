// File: src/main/java/com/mobinyousefi/cabbooking/model/Driver.java
package com.mobinyousefi.cabbooking.model;

import com.mobinyousefi.cabbooking.model.enums.CabType;
import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String fullName;

    @Column(nullable = false, length = 30, unique = true)
    private String licenseNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CabType cabType;

    @Column(nullable = false, length = 120)
    private String currentArea;

    @Column(nullable = false)
    private boolean available;

    public Driver() {
    }

    public Driver(String fullName, String licenseNumber, CabType cabType, String currentArea, boolean available) {
        this.fullName = fullName;
        this.licenseNumber = licenseNumber;
        this.cabType = cabType;
        this.currentArea = currentArea;
        this.available = available;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public CabType getCabType() {
        return cabType;
    }

    public String getCurrentArea() {
        return currentArea;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setCabType(CabType cabType) {
        this.cabType = cabType;
    }

    public void setCurrentArea(String currentArea) {
        this.currentArea = currentArea;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
