package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.ContactDTO;
import com.coders.vehicle.entity.ContactEntity;
import com.coders.vehicle.repository.ContactRepository;
import com.coders.vehicle.service.ContactService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void save(ContactDTO contactDTO) {
        contactRepository.save(toEntity(contactDTO));
    }

    @Override
    public void update(Integer id, ContactDTO contactDTO) {
        contactRepository.findById(id).ifPresent(entity -> contactRepository.save(toEntity(contactDTO)));
    }

    @Override
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<ContactDTO> getAll() {
        List<ContactEntity> entities = (List<ContactEntity>) contactRepository.findAll();
        List<ContactDTO> dtoList = new ArrayList<>();
        for (ContactEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    public static @NotNull ContactDTO toDto(@NotNull ContactEntity entity) {
        return new ContactDTO(entity.getId(), entity.getName(), entity.getCity(), entity.getEmail(), entity.getPhoneNumber());
    }

    @Contract("_ -> new")
    public static @NotNull ContactEntity toEntity(@NotNull ContactDTO dto) {
        return new ContactEntity(dto.getId(), dto.getName(), dto.getCity(), dto.getEmail(), dto.getPhoneNumber());
    }

}
