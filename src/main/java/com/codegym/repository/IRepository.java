package com.codegym.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();

    void save(T t);

    void delete(Long id);

    List<T> findByName(String name);

    T findById(Long id);
}
