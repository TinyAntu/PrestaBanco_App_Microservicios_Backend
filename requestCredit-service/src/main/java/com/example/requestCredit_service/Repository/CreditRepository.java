package com.example.requestCredit_service.Repository;

import com.example.requestCredit_service.Entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity, Long> {
    List<CreditEntity> findByUserId(Long ID);
    CreditEntity findByIdCredit(Long id);
}
