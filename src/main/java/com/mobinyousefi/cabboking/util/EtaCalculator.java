// File: src/main/java/com/mobinyousefi/cabbooking/util/EtaCalculator.java
package com.mobinyousefi.cabbooking.util;

public final class EtaCalculator {

    private EtaCalculator() {
    }

    /**
     * Very simple heuristic ETA (minutes).
     * In a real system this would use mapping APIs, traffic, distance, etc.
     */
    public static int estimateEtaMinutes(String pickupArea, String dropArea) {
        if (pickupArea == null || dropArea == null) {
            return 10;
        }
        int base = 8;
        int diff = Math.abs(pickupArea.length() - dropArea.length());
        int eta = base + diff;
        return Math.max(5, Math.min(45, eta));
    }
}
