package com.example.simulate_service.controllers;

import com.example.simulate_service.services.SimulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/simulate")
//CrossOrigin("*")
public class SimulateController {
    @Autowired
    SimulateService simulateService;

    @GetMapping("/simulation")
    public ResponseEntity<Long> simulateMonthlyPayment(@RequestParam("capital") int capital,
                                                       @RequestParam("annual_interest") double interest,
                                                       @RequestParam("years") double years) {
        Long monthlyPayment = simulateService.montly_Share(capital, interest, years);
        return ResponseEntity.ok(monthlyPayment); // The value of monthly payment
    }
}
