package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.CreditAndBarterDTO;
import com.coders.vehicle.entity.CreditAndBarterEntity;
import com.coders.vehicle.repository.CreditAndBarterRepository;
import com.coders.vehicle.service.CreditAndBarterService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditAndBarterServiceImpl implements CreditAndBarterService {
    private final CreditAndBarterRepository creditAndBarterRepository;

    @Autowired
    public CreditAndBarterServiceImpl(CreditAndBarterRepository creditAndBarterRepository) {
        this.creditAndBarterRepository = creditAndBarterRepository;
    }

    @Override
    public void save(CreditAndBarterDTO creditAndBarterDTO) {
        creditAndBarterRepository.save(toEntity(creditAndBarterDTO));
    }

    @Override
    public void update(Integer id, CreditAndBarterDTO creditAndBarterDTO) {
        creditAndBarterRepository.findById(id).ifPresent(entity -> creditAndBarterRepository.save(toEntity(creditAndBarterDTO)));
    }

    @Override
    public void delete(Integer id) {
        creditAndBarterRepository.deleteById(id);
    }

    @Override
    public List<CreditAndBarterDTO> getAll() {
        List<CreditAndBarterEntity> entities = (List<CreditAndBarterEntity>) creditAndBarterRepository.findAll();
        List<CreditAndBarterDTO> dtoList = new ArrayList<>();
        for (CreditAndBarterEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    public static @NotNull CreditAndBarterDTO toDto(@NotNull CreditAndBarterEntity entity) {
        return new CreditAndBarterDTO(entity.getId(), entity.isHasCredit(), entity.isBarterPossible());
    }

    @Contract("_ -> new")
    public static @NotNull CreditAndBarterEntity toEntity(@NotNull CreditAndBarterDTO dto) {
        return new CreditAndBarterEntity(dto.getId(), dto.isHasCredit(), dto.isBarterPossible());
    }
}
