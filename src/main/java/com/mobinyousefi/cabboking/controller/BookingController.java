// File: src/main/java/com/mobinyousefi/cabbooking/controller/BookingController.java
package com.mobinyousefi.cabbooking.controller;

import com.mobinyousefi.cabbooking.dto.RideSearchRequest;
import com.mobinyousefi.cabbooking.exception.ResourceNotFoundException;
import com.mobinyousefi.cabbooking.model.Ride;
import com.mobinyousefi.cabbooking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/search")
    public String searchRide(@ModelAttribute("rideSearchRequest") @Valid RideSearchRequest request,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cabTypes", com.mobinyousefi.cabbooking.model.enums.CabType.values());
            return "home";
        }

        try {
            Ride ride = bookingService.searchAndPrepareRide(request);
            model.addAttribute("ride", ride);
            return "searchResults";
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("cabTypes", com.mobinyousefi.cabbooking.model.enums.CabType.values());
            return "home";
        }
    }

    @PostMapping("/confirm")
    public String confirmRide(@RequestParam("rideId") Long rideId, Model model) {
        Ride confirmedRide = bookingService.confirmRide(rideId);
        model.addAttribute("ride", confirmedRide);
        return "bookingSuccess";
    }
}
