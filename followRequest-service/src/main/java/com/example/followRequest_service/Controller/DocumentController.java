package com.example.followRequest_service.Controller;


import com.example.followRequest_service.Entity.DocumentEntity;
import com.example.followRequest_service.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
@CrossOrigin("*")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/doclist/{id}")
    public ResponseEntity<List<DocumentEntity>> listDocuments(@PathVariable Long id){
        List<DocumentEntity> Docs = documentService.getDocuments(id);
        return ResponseEntity.ok(Docs);
    }

    @PostMapping("/create")
    public ResponseEntity<DocumentEntity> saveDocument(@RequestBody DocumentEntity document){
        DocumentEntity Doc = documentService.saveDocument(document);
        return ResponseEntity.ok(Doc);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        DocumentEntity document = documentService.getDocumentById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFilename() + "\"")
                .body(document.getFile());
    }
}