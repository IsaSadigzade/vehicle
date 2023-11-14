package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.VinCodeDTO;
import com.coders.vehicle.entity.VinCodeEntity;
import com.coders.vehicle.repository.VinCodeRepository;
import com.coders.vehicle.service.VinCodeService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VinCodeServiceImpl implements VinCodeService {
    private final VinCodeRepository vinCodeRepository;

    @Autowired
    public VinCodeServiceImpl(VinCodeRepository vinCodeRepository) {
        this.vinCodeRepository = vinCodeRepository;
    }

    @Override
    public void save(VinCodeDTO vinCodeDTO) {
        vinCodeRepository.save(toEntity(vinCodeDTO));
    }

    @Override
    public void update(Integer id, VinCodeDTO vinCodeDTO) {
        vinCodeRepository.findById(id).ifPresent(entity -> vinCodeRepository.save(toEntity(vinCodeDTO)));
    }

    @Override
    public void delete(Integer id) {
        vinCodeRepository.deleteById(id);
    }

    @Override
    public List<VinCodeDTO> getAll() {
        List<VinCodeEntity> entities = (List<VinCodeEntity>) vinCodeRepository.findAll();
        List<VinCodeDTO> dtoList = new ArrayList<>();
        for (VinCodeEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    private @NotNull VinCodeDTO toDto(@NotNull VinCodeEntity entity) {
        return new VinCodeDTO(entity.getId(), entity.getVinCode());
    }

    @Contract("_ -> new")
    private @NotNull VinCodeEntity toEntity(@NotNull VinCodeDTO dto) {
        return new VinCodeEntity(dto.getId(), dto.getVinCode());
    }
}
