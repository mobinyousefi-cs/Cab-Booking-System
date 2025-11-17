// File: src/main/java/com/mobinyousefi/cabbooking/dto/RideSearchRequest.java
package com.mobinyousefi.cabbooking.dto;

import com.mobinyousefi.cabbooking.model.enums.CabType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RideSearchRequest {

    @NotBlank
    private String pickupArea;

    @NotBlank
    private String dropArea;

    @NotNull
    private CabType cabType;

    public String getPickupArea() {
        return pickupArea;
    }

    public void setPickupArea(String pickupArea) {
        this.pickupArea = pickupArea;
    }

    public String getDropArea() {
        return dropArea;
    }

    public void setDropArea(String dropArea) {
        this.dropArea = dropArea;
    }

    public CabType getCabType() {
        return cabType;
    }

    public void setCabType(CabType cabType) {
        this.cabType = cabType;
    }
}
