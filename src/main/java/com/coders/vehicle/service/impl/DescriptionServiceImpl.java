package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.DescriptionDTO;
import com.coders.vehicle.entity.DescriptionEntity;
import com.coders.vehicle.repository.DescriptionRepository;
import com.coders.vehicle.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DescriptionServiceImpl implements DescriptionService {
    private final DescriptionRepository descriptionRepository;

    @Autowired
    public DescriptionServiceImpl(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    @Override
    public void save(DescriptionDTO descriptionDTO) {
        descriptionRepository.save(toEntity(descriptionDTO));
    }

    @Override
    public void update(Integer id, DescriptionDTO descriptionDTO) {
        descriptionRepository.findById(id).ifPresent(entity -> descriptionRepository.save(toEntity(descriptionDTO)));
    }

    @Override
    public void delete(Integer id) {
        descriptionRepository.deleteById(id);
    }

    @Override
    public List<DescriptionDTO> getAll() {
        List<DescriptionEntity> entities = (List<DescriptionEntity>) descriptionRepository.findAll();
        List<DescriptionDTO> dtoList = new ArrayList<>();
        for (DescriptionEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    private DescriptionDTO toDto(DescriptionEntity entity) {
        return new DescriptionDTO(entity.getId(), entity.getDescription());
    }

    private DescriptionEntity toEntity(DescriptionDTO dto) {
        return new DescriptionEntity(dto.getId(), dto.getDescription());
    }
}
