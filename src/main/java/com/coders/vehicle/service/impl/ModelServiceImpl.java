package com.coders.vehicle.service.impl;

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

    @Override
    public List<ModelDTO> getAllByBrandId(Integer id) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(id);
        List<ModelEntity> entities = modelRepository.findAllByBrandEntity(brandEntity);
        List<ModelDTO> dtoList = new ArrayList<>();
        for (ModelEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    public static @NotNull ModelDTO toDto(@NotNull ModelEntity entity) {
        return new ModelDTO(
                entity.getId(),
                entity.getModelName(),
                BrandServiceImpl.toDto(entity.getBrandEntity())
        );
    }

    @Contract("_ -> new")
    public static @NotNull ModelEntity toEntity(@NotNull ModelDTO dto) {
        return new ModelEntity(
                dto.getId(),
                dto.getModelName(),
                BrandServiceImpl.toEntity(dto.getBrandDTO())
        );
    }
}
