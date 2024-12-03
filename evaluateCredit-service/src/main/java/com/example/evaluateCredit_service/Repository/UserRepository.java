package com.example.evaluateCredit_service.Repository;


import com.example.evaluateCredit_service.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    }
