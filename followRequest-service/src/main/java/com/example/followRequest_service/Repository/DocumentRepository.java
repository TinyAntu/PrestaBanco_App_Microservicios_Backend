package com.example.followRequest_service.Repository;

import com.example.followRequest_service.Entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity,Long> {

    List<DocumentEntity> findByIdCredit(Long id);


}
