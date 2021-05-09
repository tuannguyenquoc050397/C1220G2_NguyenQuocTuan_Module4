package com.example.demo.service;

import org.springframework.data.domain.Page;

import java.util.List;

public interface GeneralService<T> {

    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
