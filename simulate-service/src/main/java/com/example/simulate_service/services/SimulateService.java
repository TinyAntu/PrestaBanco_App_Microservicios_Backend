package com.example.simulate_service.services;

import org.springframework.stereotype.Service;

@Service
public class SimulateService {

    public Long montly_Share(Integer Capital, Double Annual_interest, Double Years){
        Double M = 0.0;
        Double r = Annual_interest/100/12;
        Double n = Years*12;
        M = Capital*r* Math.pow(1+r,n) / (Math.pow(1 + r, n) -1);
        return Math.round(M);
    }


}
