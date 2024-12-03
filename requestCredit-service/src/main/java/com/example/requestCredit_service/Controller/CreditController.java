package com.example.requestCredit_service.Controller;

import com.example.requestCredit_service.Entity.CreditEntity;
import com.example.requestCredit_service.Service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/request")
//@CrossOrigin("*")
public class CreditController {
    @Autowired
    CreditService creditService;

    @PostMapping("/create")
    public ResponseEntity<CreditEntity> saveCredit(@RequestBody CreditEntity credit){
        CreditEntity Credit = creditService.saveCredit(credit.getCapital(), credit.getAnnual_interest(), credit.getYears(),
                credit.getType(), credit.getIncome(), credit.getProperty_value(), credit.getDebt(), credit.getUserId());
        return ResponseEntity.ok(Credit);
    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<CreditEntity>> getAllCredits(){
        List<CreditEntity> Credits = creditService.getCredits();
        return ResponseEntity.ok(Credits);
    }

    @GetMapping("/creditlist/{id}")
    public ResponseEntity<List<CreditEntity>> listCredit(@PathVariable Long id){
        List<CreditEntity> credits = creditService.getCredits(id);
        return ResponseEntity.ok(credits);
    }

    @GetMapping("/getCredit/{id}")
    public ResponseEntity<CreditEntity> getCredit(@PathVariable Long id){
        CreditEntity credit = creditService.getCreditById(id);
        return ResponseEntity.ok(credit);
    }

}
