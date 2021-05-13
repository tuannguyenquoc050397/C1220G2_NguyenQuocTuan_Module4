package com.example.demo.service.impl;

import com.example.demo.model.BookCode;
import com.example.demo.repository.BookCodeRepository;
import com.example.demo.service.BookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookCodeServiceImpl implements BookCodeService {
    @Autowired
    private BookCodeRepository bookCodeRepository;

    @Override
    public List<BookCode> findAll() {
        return bookCodeRepository.findAll();
    }

    @Override
    public void save(BookCode bookCode) {
        bookCodeRepository.save(bookCode);
    }

    @Override
    public Optional<BookCode> findByCode(Long code) {
        return bookCodeRepository.findByCode(code);
    }

    @Transactional
    @Override
    public void deleteByCode(Long code) {
        bookCodeRepository.deleteByCode(code);
    }

    @Override
    public void deleteById(Long id) {
        bookCodeRepository.deleteById(id);
    }
}
