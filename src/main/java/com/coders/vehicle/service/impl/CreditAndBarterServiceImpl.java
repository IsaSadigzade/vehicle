package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.ExtrasDTO;
import com.coders.vehicle.entity.ExtrasEntity;
import com.coders.vehicle.repository.ExtrasRepository;
import com.coders.vehicle.service.ExtrasService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtrasServiceImpl implements ExtrasService {
    private final ExtrasRepository extrasRepository;

    @Autowired
    public ExtrasServiceImpl(ExtrasRepository extrasRepository) {
        this.extrasRepository = extrasRepository;
    }

    @Override
    public void save(ExtrasDTO extrasDTO) {
        extrasRepository.save(toEntity(extrasDTO));
    }

    @Override
    public void update(Integer id, ExtrasDTO extrasDTO) {
        extrasRepository.findById(id).ifPresent(entity -> extrasRepository.save(toEntity(extrasDTO)));
    }

    @Override
    public void delete(Integer id) {
        extrasRepository.deleteById(id);
    }

    @Override
    public List<ExtrasDTO> getAll() {
        List<ExtrasEntity> entities = (List<ExtrasEntity>) extrasRepository.findAll();
        List<ExtrasDTO> dtoList = new ArrayList<>();
        for (ExtrasEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    private @NotNull ExtrasDTO toDto(@NotNull ExtrasEntity entity) {
        return new ExtrasDTO(entity.getId(), entity.isHasCredit(), entity.isBarterPossible());
    }

    @Contract("_ -> new")
    private @NotNull ExtrasEntity toEntity(@NotNull ExtrasDTO dto) {
        return new ExtrasEntity(dto.getId(), dto.isHasCredit(), dto.isBarterPossible());
    }
}
