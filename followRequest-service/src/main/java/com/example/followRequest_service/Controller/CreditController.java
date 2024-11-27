package com.example.followRequest_service.Controller;

import com.example.followRequest_service.Entity.CreditEntity;
import com.example.followRequest_service.Service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/follow")
public class CreditController {
    @Autowired
    CreditService creditService;

    @GetMapping("/E1/{id}")
    public ResponseEntity<Boolean> Follow1(@PathVariable Long id){
        Boolean E1 = creditService.E1(id);
        return ResponseEntity.ok(E1);
    }

    @GetMapping("/creditlist/{id}")
    public ResponseEntity<List<CreditEntity>> listCredit(@PathVariable Long id){
        List<CreditEntity> credits = creditService.getCredits(id);
        return ResponseEntity.ok(credits);
    }

}
