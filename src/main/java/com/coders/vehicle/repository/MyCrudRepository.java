package com.coders.vehicle.repository;

import java.util.Set;

public interface MyCrudRepository<T, I> {
    void save(T t);
    void update(I i, T t);
    void delete(I i);
    Set<T> getAll();
}
