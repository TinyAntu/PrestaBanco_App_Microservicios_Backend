package com.example.evaluateCredit_service.Controller;

import com.example.evaluateCredit_service.Entity.CreditEntity;
import com.example.evaluateCredit_service.Service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/evaluate")
public class CreditController {
    @Autowired
    CreditService creditService;

    @GetMapping("/getAll")
    public  ResponseEntity<List<CreditEntity>> getAllCredits(){
        List<CreditEntity> Credits = creditService.getAllCredits();
        return ResponseEntity.ok(Credits);
    }

    @GetMapping("/R1/{id}")
    public ResponseEntity<Boolean> Step1(@PathVariable Long id){
        Boolean R1 = creditService.R1(id);
        return ResponseEntity.ok(R1);
    }

    @GetMapping("/R4/{id}")
    public ResponseEntity<Boolean> Step4(@PathVariable Long id){
        Boolean R4 = creditService.R4(id);
        return ResponseEntity.ok(R4);
    }

    @GetMapping("/R5/{id}")
    public ResponseEntity<Boolean> Step5(@PathVariable Long id){
        Boolean R5 = creditService.R5(id);
        return ResponseEntity.ok(R5);
    }

    @GetMapping("/R6/{id}")
    public ResponseEntity<Boolean> Step6(@PathVariable Long id){
        Boolean R6 = creditService.R6(id);
        return ResponseEntity.ok(R6);
    }

    @GetMapping("/total/{id}")
    public ResponseEntity<Long> TotalCost( @PathVariable Long id){
        Long Total = creditService.total_cost(id);
        return  ResponseEntity.ok(Total);
    }

}
