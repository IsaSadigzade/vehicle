package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.PriceDTO;
import com.coders.vehicle.entity.PriceEntity;
import com.coders.vehicle.repository.PriceRepository;
import com.coders.vehicle.service.PriceService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void save(PriceDTO priceDTO) {
        priceRepository.save(toEntity(priceDTO));
    }

    @Override
    public void update(Integer id, PriceDTO priceDTO) {
        priceRepository.findById(id).ifPresent(entity -> priceRepository.save(toEntity(priceDTO)));
    }

    @Override
    public void delete(Integer id) {
        priceRepository.deleteById(id);
    }

    @Override
    public List<PriceDTO> getAll() {
        List<PriceEntity> entities = (List<PriceEntity>) priceRepository.findAll();
        List<PriceDTO> dtoList = new ArrayList<>();
        for (PriceEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    private @NotNull PriceDTO toDto(@NotNull PriceEntity entity) {
        return new PriceDTO(entity.getId(), entity.getAmount(), entity.getCurrency());
    }

    @Contract("_ -> new")
    private @NotNull PriceEntity toEntity(@NotNull PriceDTO dto) {
        return new PriceEntity(dto.getId(), dto.getAmount(),dto.getCurrency());
    }
}
