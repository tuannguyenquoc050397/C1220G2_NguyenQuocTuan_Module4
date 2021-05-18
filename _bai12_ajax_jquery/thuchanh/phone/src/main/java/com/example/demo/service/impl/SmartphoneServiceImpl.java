package com.example.demo.service.impl;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import com.example.demo.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return smartphoneRepository.findAll(pageable);
    }

    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }
}
