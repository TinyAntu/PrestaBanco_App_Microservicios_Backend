package com.example.evaluateCredit_service.Service;

import com.example.evaluateCredit_service.Entity.UserEntity;
import com.example.evaluateCredit_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserEntity findUserById(Long Id){
        return userRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public int AgeInYears(Date birthdate) {
        LocalDate Local_birthdate;
        if (birthdate instanceof java.sql.Date) {
            Local_birthdate = ((java.sql.Date) birthdate).toLocalDate();
        } else {
            Local_birthdate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        LocalDate Actual_date = LocalDate.now();
        return Period.between(Local_birthdate, Actual_date).getYears();
    }
}
