package com.example.followRequest_service.Service;

import com.example.followRequest_service.Entity.CreditEntity;
import com.example.followRequest_service.Repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.followRequest_service.Entity.DocumentEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CreditService {
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    DocumentService documentService;
    @Autowired
    RestTemplate restTemplate;

    public Boolean E1(Long id) {
        CreditEntity Credit = restTemplate.getForObject("http://requestCredit-service/api/request/getCredit/{id}", CreditEntity.class, id);
        Integer type_credit = Credit.getType();
        List<DocumentEntity> Docs = documentService.getDocuments(id);

        //If anything (except state) is null return false
        if (Credit.getIdCredit() == null ||
                Credit.getCapital() == null ||
                Credit.getAnnual_interest() == null ||
                Credit.getYears() == null ||
                Credit.getType() == null ||
                Credit.getIncome() == null ||
                Credit.getLevel() == null ||
                Credit.getProperty_value() == null ||
                Credit.getDebt() == null ||
                Credit.getUserId() == null) {
            return false;
        }

        return switch (type_credit) {
            case 1 -> // First home
                    Docs.size() >= 3;
            case 2 -> // Second home
                    Docs.size() >= 4;
            case 3 -> // Market property
                    Docs.size() >= 4;
            case 4 -> // Remodeling
                    Docs.size() >= 3;
            default -> false; // Invalid credit type
        };
    }

    public List<CreditEntity> getCredits(Long id){
        List<CreditEntity> credits = restTemplate.getForObject("http://requestCredit-service/api/request/creditlist/{id}", List.class, id);
        return credits;
    }


}
