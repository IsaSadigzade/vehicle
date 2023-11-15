package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.BrandDTO;
import com.coders.vehicle.entity.BrandEntity;
import com.coders.vehicle.repository.BrandRepository;
import com.coders.vehicle.service.BrandService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void save(BrandDTO brandDTO) {
        brandRepository.save(toEntity(brandDTO));
    }

    @Override
    public void update(Integer id, BrandDTO brandDTO) {
        brandRepository.findById(id).ifPresent(entity -> brandRepository.save(toEntity(brandDTO)));
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<BrandDTO> getAll() {
        List<BrandEntity> entities = (List<BrandEntity>) brandRepository.findAll();
        List<BrandDTO> dtoList = new ArrayList<>();
        for (BrandEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }
    @Contract("_ -> new")
    public static @NotNull BrandDTO toDto(@NotNull BrandEntity entity) {
        return new BrandDTO(entity.getId(), entity.getBrandName());
    }

    @Contract("_ -> new")
    public static @NotNull BrandEntity toEntity(@NotNull BrandDTO dto) {
        return new BrandEntity(dto.getId(), dto.getBrandName());
    }
}
