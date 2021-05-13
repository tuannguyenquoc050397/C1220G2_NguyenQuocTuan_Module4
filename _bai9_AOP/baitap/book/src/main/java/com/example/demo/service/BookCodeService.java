package com.example.demo.service;

import com.example.demo.model.BookCode;

import java.util.List;
import java.util.Optional;

public interface BookCodeService {
    List<BookCode> findAll();
    void save(BookCode bookCode);
    Optional<BookCode> findByCode(Long code);
    void deleteByCode(Long code);
    void deleteById(Long id);
}
