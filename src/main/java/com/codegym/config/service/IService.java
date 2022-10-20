package com.codegym.config.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    void save(T t);

    void delete(Long id);

    List<T> findByName(String name);

    T findById(Long id);
}
