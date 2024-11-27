package com.example.evaluateCredit_service.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "credits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idCredit;

    //The amount of the Credit
    private Integer capital;

    private Double annual_interest;

    private Double years;

    // 1 =first home, 2 = Second home, 3 = Market property, 4 = remodeling
    private Integer type;

    private Integer income;

    //Null == to be checked, false == disapproved, true == approved
    @Column
    private Boolean state = null;

    private Integer level;

    private Integer property_value;

    private Integer debt;

    //To follow the processes
    private Integer e;

    //One credit needs a user
    private Long userId;
}
