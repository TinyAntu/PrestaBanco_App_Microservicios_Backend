package com.example.evaluateCredit_service.Repository;

import com.example.evaluateCredit_service.Entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity, Long> {
}
