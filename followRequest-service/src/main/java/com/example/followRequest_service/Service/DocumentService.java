package com.example.followRequest_service.Service;

import com.example.followRequest_service.Entity.DocumentEntity;
import com.example.followRequest_service.Repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    public DocumentEntity saveDocument (DocumentEntity document){
        if (document == null) {
            throw new IllegalArgumentException("The Document can't be null.");
        }
        return documentRepository.save(document);
    }

    @Transactional
    public List<DocumentEntity> getDocuments(Long id){
        if (id == null) {
            throw new IllegalArgumentException("The ID can't be Null.");
        }
        return documentRepository.findByIdCredit(id);
    }

    public DocumentEntity getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }
}
