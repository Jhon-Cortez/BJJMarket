/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.shared;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author juan
 */
public abstract class AbstractCrudController<ResponseDTO, RequestDTO> {
    protected final ICrudService<ResponseDTO, RequestDTO, UUID> service;

    public AbstractCrudController(ICrudService<ResponseDTO, RequestDTO, UUID> service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<ResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<ResponseDTO> save(@RequestBody RequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable UUID id, @RequestBody RequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO> updatePartial(@PathVariable UUID id, @RequestBody RequestDTO dto) {
        return ResponseEntity.ok(service.updatePartial(id, dto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/logical/{id}")
    public ResponseEntity<Void> deletePartial(@PathVariable UUID id) {
        service.deletePartial(id);
        return ResponseEntity.noContent().build();
    }
}
