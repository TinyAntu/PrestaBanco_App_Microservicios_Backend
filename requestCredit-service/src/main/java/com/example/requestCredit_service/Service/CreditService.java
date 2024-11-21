package com.example.requestCredit_service.Service;

import com.example.requestCredit_service.Entity.CreditEntity;
import com.example.requestCredit_service.Repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CreditService {
    @Autowired
    CreditRepository creditRepository;

    public CreditEntity saveCredit(Integer capital, Double annual_interest, Double years, Integer type,
                                   Integer income, Integer property_value, Integer debt, Long userId) {
        CreditEntity credit = CreditEntity.builder()
                .capital(capital)
                .annual_interest(annual_interest)
                .years(years)
                .type(type)
                .income(income)
                .property_value(property_value)
                .debt(debt)
                .userId(userId)
                .build();
        credit.setLevel(1);
        credit.setE(1);
        return creditRepository.save(credit);
    }
}
