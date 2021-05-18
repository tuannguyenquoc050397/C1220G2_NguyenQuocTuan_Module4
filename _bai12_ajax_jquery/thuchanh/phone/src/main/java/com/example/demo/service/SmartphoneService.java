package com.example.demo.service;

import com.example.demo.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SmartphoneService {

    Page<Smartphone> findAll(Pageable pageable);

    List<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartphone);

    void remove(Long id);
}
