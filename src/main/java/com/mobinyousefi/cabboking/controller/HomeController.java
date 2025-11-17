// File: src/main/java/com/mobinyousefi/cabbooking/controller/HomeController.java
package com.mobinyousefi.cabbooking.controller;

import com.mobinyousefi.cabbooking.dto.RideSearchRequest;
import com.mobinyousefi.cabbooking.model.enums.CabType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("rideSearchRequest", new RideSearchRequest());
        model.addAttribute("cabTypes", CabType.values());
        return "home";
    }
}
