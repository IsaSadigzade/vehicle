package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.BrandDTO;
import com.coders.vehicle.dto.ModelDTO;
import com.coders.vehicle.entity.BrandEntity;
import com.coders.vehicle.entity.ModelEntity;
import com.coders.vehicle.repository.ModelRepository;
import com.coders.vehicle.service.ModelService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void save(ModelDTO modelDTO) {
        modelRepository.save(toEntity(modelDTO));
    }

    @Override
    public void update(Integer id, ModelDTO modelDTO) {
        modelRepository.findById(id).ifPresent(entity -> modelRepository.save(toEntity(modelDTO)));
    }

    @Override
    public void delete(Integer id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<ModelDTO> getAll() {
        List<ModelEntity> entities = (List<ModelEntity>) modelRepository.findAll();
        List<ModelDTO> dtoList = new ArrayList<>();
        for (ModelEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    private @NotNull ModelDTO toDto(@NotNull ModelEntity entity) {
        ModelDTO dto = new ModelDTO();
        dto.setId(entity.getId());
        dto.setModelName(entity.getModelName());
        if (entity.getBrandEntity() != null) {
            dto.setBrandDTO(toBrandDto(entity.getBrandEntity()));
        }
        return dto;
    }

    @Contract("_ -> new")
    private @NotNull ModelEntity toEntity(@NotNull ModelDTO dto) {
        ModelEntity entity = new ModelEntity();
        entity.setId(dto.getId());
        entity.setModelName(dto.getModelName());
        if (dto.getBrandDTO() != null) {
            entity.setBrandEntity(toBrandEntity(dto.getBrandDTO()));
        }
        return entity;
    }
    private @NotNull BrandDTO toBrandDto(@NotNull BrandEntity brandEntity) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brandEntity.getId());
        brandDTO.setBrandName(brandEntity.getBrandName());
        return brandDTO;
    }
    private @NotNull BrandEntity toBrandEntity(@NotNull BrandDTO brandDTO) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(brandDTO.getId());
        brandEntity.setBrandName(brandDTO.getBrandName());
        return brandEntity;
    }
}
