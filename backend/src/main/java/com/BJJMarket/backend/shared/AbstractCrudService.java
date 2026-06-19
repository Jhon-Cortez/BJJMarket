/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.shared;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author juan
 */
public abstract class AbstractCrudService<Entity extends BaseEntity, RequestDTO, ResponseDTO, Repository extends JpaRepository<Entity, UUID>> implements ICrudService<ResponseDTO, RequestDTO, UUID> {
    protected final Repository repository;

    public AbstractCrudService(Repository repository) {
        this.repository = repository;
    }
    
    protected abstract Entity toEntity(RequestDTO dto);
    protected abstract ResponseDTO toResponse(Entity entity);
    protected abstract void merge(RequestDTO dto, Entity entity);
    
    @Override
    public List<ResponseDTO> findAll() {
        return repository.findAll().stream().filter(e -> !"inactive".equals(e.getStatus())).map(this::toResponse).toList();
    }

    @Override
    public ResponseDTO findById(UUID id) {
        return repository.findById(id).map(this::toResponse).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public ResponseDTO save(RequestDTO dto) {
        Entity entity = toEntity(dto);
        entity.setStatus("active");
        return toResponse(repository.save(entity));
    }

    @Override
    public ResponseDTO update(UUID id, RequestDTO dto) {
        Entity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        
        merge(dto, entity);
        entity.setId(id);
        return toResponse(repository.save(entity));
    }

    @Override
    public ResponseDTO updatePartial(UUID id, RequestDTO dto) {
        Entity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        
        merge(dto, entity);
        entity.setId(id);
        return toResponse(repository.save(entity));
    }

    @Override
    public void delete(UUID id) {
        Entity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        repository.delete(entity);
    }

    @Override
    public void deletePartial(UUID id) {
        Entity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        entity.setStatus("inactive");
        repository.save(entity);
    }
    
}
