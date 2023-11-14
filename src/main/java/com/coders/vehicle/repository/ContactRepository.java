package com.coders.vehicle.repository;

import com.coders.vehicle.entity.ContactEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {
}