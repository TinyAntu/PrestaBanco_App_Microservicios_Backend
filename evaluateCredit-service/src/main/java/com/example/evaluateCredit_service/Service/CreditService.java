package com.example.evaluateCredit_service.Service;

import com.example.evaluateCredit_service.Entity.CreditEntity;
import com.example.evaluateCredit_service.Entity.UserEntity;
import com.example.evaluateCredit_service.Repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CreditService {
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    UserService userService;
    @Autowired
    RestTemplate restTemplate;

    public Long total_cost(Long id){
        CreditEntity Credit = creditRepository.findByIdCredit(id);
        Integer FireHazardSecure = 20000;
        Long Montly_share = restTemplate.getForObject(
                "http://simulate-service/api/simulate/simulation?capital="
                        + Credit.getCapital()
                        + "&annual_interest="
                        + Credit.getAnnual_interest()
                        + "&years="
                        + Credit.getYears(),
                Long.class
        );
        Double Administration_comision = Credit.getCapital()*0.01;
        Double DeductionSecure = Credit.getCapital()*0.0003;
        Double Months = Credit.getYears()*12;
        Double Actual_Montly_share = Montly_share + DeductionSecure+ FireHazardSecure;
        Double Total_Cost = Actual_Montly_share*Months + Administration_comision;
        return Math.round(Total_Cost);
    }

    public Boolean share_income(Long share, Integer income){
        Double relation = (share/(double)income)*100;
        return relation <= 35;
    }

    public Boolean R1(Long id){
        CreditEntity Credit = creditRepository.findByIdCredit(id);
        Long Share = restTemplate.getForObject(
                "http://simulate-service/api/simulate/simulation?capital="
                        + Credit.getCapital()
                        + "&annual_interest="
                        + Credit.getAnnual_interest()
                        + "&years="
                        + Credit.getYears(),
                Long.class
        );
        return share_income(Share, Credit.getIncome());
    }

    public Boolean R4(Long id){
        CreditEntity Credit = creditRepository.findByIdCredit(id);
        Integer Debt = Credit.getDebt();
        Integer Income = Credit.getIncome();
        Long Share = restTemplate.getForObject(
                "http://simulate-service/api/simulate/simulation?capital="
                        + Credit.getCapital()
                        + "&annual_interest="
                        + Credit.getAnnual_interest()
                        + "&years="
                        + Credit.getYears(),
                Long.class
        );
        return Income * 0.5 >= Debt + Share;
    }

    public Boolean R5(Long id){
        CreditEntity Credit = creditRepository.findByIdCredit(id);
        Integer Credit_type = Credit.getType();
        Integer Financing = financing(Credit.getProperty_value(), Credit.getCapital());
        return switch (Credit_type) {
            case 1 -> // First home
                    Financing <= 80;
            case 2 -> // Second home
                    Financing <= 70;
            case 3 -> // Market property
                    Financing <= 60;
            case 4 -> // Remodeling
                    Financing <= 50;
            default -> false; // it exceeds the maximum
        };
    }

    public Boolean R6(Long id){
        CreditEntity Credit = creditRepository.findByIdCredit(id);
        UserEntity user = userService.findUserById(Credit.getUserId());
        Integer user_age = userService.AgeInYears(user.getBirthdate());

        return user_age + Credit.getYears() < 70;
    }

    public List<CreditEntity> getCredits(){
        return creditRepository.findAll();
    }

    public CreditEntity updateCredit(Long id, CreditEntity credit) {
        if (!creditRepository.existsById(id)) {
            throw new EntityNotFoundException("Credit not found with ID: " + id);
        }
        credit.setIdCredit(id);
        return creditRepository.save(credit);
    }

    public Integer financing(Integer value, Integer amount ){
        System.out.print((int) ((value / (double) amount) * 100));
        return  (int) ((value / (double) amount) * 100);
    }
}
